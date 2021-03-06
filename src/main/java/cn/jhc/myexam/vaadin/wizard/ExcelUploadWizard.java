package cn.jhc.myexam.vaadin.wizard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import org.eobjects.metamodel.DataContext;
import org.eobjects.metamodel.data.DataSet;
import org.eobjects.metamodel.data.Row;
import org.eobjects.metamodel.excel.ExcelConfiguration;
import org.eobjects.metamodel.excel.ExcelDataContext;
import org.eobjects.metamodel.query.Query;
import org.eobjects.metamodel.schema.Column;
import org.eobjects.metamodel.schema.Schema;
import org.eobjects.metamodel.schema.Table;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.util.Constants;
import cn.jhc.myexam.vaadin.util.PropertyData;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Notification.Type;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Upload.Receiver;
import com.vaadin.ui.Upload.StartedEvent;
import com.vaadin.ui.Upload.StartedListener;
import com.vaadin.ui.Upload.SucceededEvent;
import com.vaadin.ui.Upload.SucceededListener;
import com.vaadin.ui.VerticalLayout;

public class ExcelUploadWizard<T> extends Wizard 
	implements Receiver, StartedListener, SucceededListener {
	
	private static final Logger logger = Logger.getLogger(ExcelUploadWizard.class.getName());
	
	private PropertyData propertyData = null;
	private Upload upload = null;
	/**
	 * Column names in excel file.
	 */
	private String[] columnNames = null;
	/**
	 * Entity class.
	 */
	private Class<T> theClass = null;
	/**
	 * Entity list extract from excel file.
	 */
	private List<T> importList;
	/**
	 * Only after upload is successed, then wizard will go to second step.
	 */
	private boolean secondStepIsOK = false; 
	
	private ExcelUploadWizardCallback<T> wizardCallback = null;
	
	public ExcelUploadWizard(Class<T> clazz, ExcelUploadWizardCallback<T> callback) {
		super();
		this.theClass = clazz;
		this.propertyData = PropertyData.create(clazz);
		this.columnNames = propertyData.getImportColumnList().toArray(new String[0]);
		this.wizardCallback = callback;
		this.addStep(new UploadExcelStep());
		this.addStep(new ConfirmImportStep());
		this.addStep(new FinishStep());
		getNextButton().setCaption("下一步");
		getBackButton().setVisible(false);
		getCancelButton().setVisible(false);
		getFinishButton().setCaption("结束");
	}
	
	@Override
	public void finish() {
		super.finish();
		wizardCallback.afterFinish();
	}

	private String getCommaSeperatedImportColumns() {
		StringBuilder sb = new StringBuilder();
		for(String s : propertyData.getImportColumnList())
			sb.append(s).append("，");
		if(sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	private class UploadExcelStep implements WizardStep, Serializable {

		@Override
		public String getCaption() {
			return "选择Excel文件";
		}

		@Override
		public Component getContent() {
			VerticalLayout layout = new VerticalLayout();
			layout.setImmediate(false);
			layout.setSizeFull();
			layout.setSpacing(true);
			
			Label infoLabel = new Label("<h2>上传注意事项</h2>"
					+ "<ul><li>文件的后缀必须是.xls或.xlsx。</li>"
					+ "<li>文件的大小不能超过5MB。</li>"
					+ "<li>服务器只会解析第1个工作表，其它工作表中的数据会被忽略。</li>"
					+ "<li>第1个工作表的第1行必须是表头，表头中的列名分别为\"" 
						+ getCommaSeperatedImportColumns() + "\"（次序无关）。</li>"
					+ "<li>服务器只解析前" + columnNames.length + "列的数据，忽略后面的数据。</li></ul><br/>",
					ContentMode.HTML);
			layout.addComponent(infoLabel);
			buildUpload();
			layout.addComponent(upload);
			layout.setComponentAlignment(upload, Alignment.MIDDLE_CENTER);
			return layout;
		}

		private void buildUpload() {
			upload = new Upload();
			upload.setButtonCaption("上传Excel文件");
			upload.addStartedListener(ExcelUploadWizard.this);
			upload.setReceiver(ExcelUploadWizard.this);
			upload.addSucceededListener(ExcelUploadWizard.this);
		}
		
		@Override
		public boolean onAdvance() {
			if(!secondStepIsOK) {
				Notification.show("必须先上传Excel文件才能进入下一步！", Notification.Type.WARNING_MESSAGE);
			}
			return secondStepIsOK;
		}

		@Override
		public boolean onBack() {
			return false;
		}
	}
	
	private class ConfirmImportStep implements WizardStep, Serializable {
		private VerticalLayout mainLayout;
		private CheckBox editableCheckBox;
		private com.vaadin.ui.Table table;

		@Override
		public String getCaption() {
			return "确认上传的数据";
		}

		@Override
		public Component getContent() {
			if(importList == null) return null;
			this.table = VaadinEntityBuilder.create(theClass).buildTable(importList);
			
			mainLayout = new VerticalLayout();
			mainLayout.setImmediate(false);
			mainLayout.setSizeFull();
			mainLayout.setSpacing(true);
			mainLayout.setMargin(true);
			
			HorizontalLayout hLayout = new HorizontalLayout();
			hLayout.setMargin(new MarginInfo(false,true,false,true));
			hLayout.setWidth("100%");
//			hLayout.setHeight("100%");
			editableCheckBox = new CheckBox("打开编辑模式", false);
			editableCheckBox.addValueChangeListener(new ValueChangeListener() {
				
				@Override
				public void valueChange(ValueChangeEvent event) {
					table.setEditable(editableCheckBox.getValue());
				}
			});
			editableCheckBox.setWidth("100px");
//			editableCheckBox.setWidth("100%");
			hLayout.addComponent(editableCheckBox);
			hLayout.setExpandRatio(editableCheckBox, 1.0f);
			hLayout.setComponentAlignment(editableCheckBox, Alignment.TOP_RIGHT);
			mainLayout.addComponent(hLayout);
			mainLayout.setExpandRatio(hLayout, 0.0f);
			
			
			table.setStyleName("page-table");
			table.setCaption("将要添加的纪录");
			table.setImmediate(false);
			table.setWidth("100%");
			table.setHeight("-1px");
//			table.setPageLength(Constants.TABLE_PAGE_SIZE);
			mainLayout.addComponent(table);
			mainLayout.setExpandRatio(table, 1.0f);
			
			return mainLayout;
		}

		@Override
		public boolean onAdvance() {
			wizardCallback.saveList(importList);
			return true;
		}

		@Override
		public boolean onBack() {
			return false;
		}
		
	}

	private class FinishStep implements WizardStep, Serializable {

		@Override
		public String getCaption() {
			return "完成导入";
		}

		@Override
		public Component getContent() {
			List<T> failedList = wizardCallback.getFailedList();
			int failed = failedList.size();
			int successed = importList.size() - failedList.size();
			VerticalLayout layout = new VerticalLayout();
			layout.setImmediate(false);
			layout.setMargin(true);
			layout.setSpacing(true);
			layout.setSizeFull();
			Label label = new Label("本次操作向服务器成功添加了" + successed +"条纪录。");
			layout.addComponent(label);
			if(failed > 0) {
				StringBuilder sb = new StringBuilder();
				for(T t : failedList) {
					sb.append("<li>" + t.toString() + "</li>");
				}
				Label label2 = new Label("其中" + failed + "条纪录无法成功添加，具体是：<br/>"
						+ "<ul>" + sb + "</ul>", ContentMode.HTML);
				layout.addComponent(label2);
			}
			return layout;
		}

		@Override
		public boolean onAdvance() {
			return true;
		}

		@Override
		public boolean onBack() {
			return false;
		}
		
	}
	
	private static File UPLOAD_FOLDER = new File("/tmp/myexamuploads/");
	
	//TODO: 上传的临时文件不会自动删除，会不会造成服务器负担？
	private File file = null;
	
	private static final long FILE_SIZE_LIMIT = 5*1024*1024; //5MB
	
	@Override
	public OutputStream receiveUpload(String filename, String mimeType) {
		FileOutputStream outputStream = null;
		try {
			//上传文件的目录必须先创建好，否则会出异常。
			if( ! UPLOAD_FOLDER.exists() )
				UPLOAD_FOLDER.mkdir();
			file = new File(UPLOAD_FOLDER.getAbsolutePath() + "/" + filename
					+ "." + System.currentTimeMillis());
			outputStream = new FileOutputStream(file);
		} catch (FileNotFoundException e) {
			Notification.show("服务器无法接收文件，请联系管理员。<br/>", e.getMessage(), Type.ERROR_MESSAGE);
			return null;
		}
		return outputStream;
	}

	@Override
	public void uploadSucceeded(SucceededEvent event) {
		ExcelConfiguration configuration = new ExcelConfiguration(1, true, true);
		DataContext context = new ExcelDataContext(file, configuration);
		if( !validateColumnNames(context) ) {
			Notification.show("表结构不合要求，请修改后重新上传！", Type.ERROR_MESSAGE);
			return;
		}
		importList = buildImportList(context);
		secondStepIsOK  = true;
		next();
	}

	protected List<T> buildImportList(DataContext context) {
		Table table = context.getDefaultSchema().getTable(0);
		Query query = context.query().from(table)
				.select(columnNames)
				.toQuery();
		logger.fine("MetaModel SQL: " + query.toString());
		
		List<T> list = new ArrayList<T>();
		DataSet dataSet = context.executeQuery(query);
		
		Column[] columns = new Column[columnNames.length];
		for(int i=0; i<columnNames.length; i++)
			columns[i] = table.getColumnByName(columnNames[i]);
		
		try {
			while(dataSet.next()) {
				Row row = dataSet.getRow();
				T item = null;
				BeanWrapper wrapper = new BeanWrapperImpl(theClass);
				for (int i = 0; i < columnNames.length; i++) {
					String property = propertyData.getPropertyNameByColumn(columnNames[i]);
					wrapper.setPropertyValue(property, (String) row.getValue(columns[i]));
				}
				item = (T) wrapper.getWrappedInstance();
				list.add(item);
			}
		} catch (Throwable t) {
			logger.severe(t.getMessage());
			return null;
		}
		finally {
			dataSet.close();
		}
		return list;
	}

	public boolean validateColumnNames(DataContext context) {
		Schema schema = context.getDefaultSchema();
		Table sheet = schema.getTable(0);
		for(String name : columnNames) {
			if(sheet.getColumnByName(name) == null)
				return false;
		}
		return true;
	}
	
	@Override
	public void uploadStarted(StartedEvent event) {
		Upload upload = event.getUpload();
		if(event.getContentLength() > FILE_SIZE_LIMIT) {
			upload.interruptUpload();
			Notification.show("上传的Excel文件不能超过5MB！", Notification.Type.ERROR_MESSAGE);
			return;
		}
		if(	 ! event.getFilename().endsWith(".xls") 
						&& ! event.getFilename().endsWith(".xlsx") ) {
			upload.interruptUpload();
			Notification.show("只能上传后缀为.xls或.xlsx的文件！", Notification.Type.ERROR_MESSAGE);
		}
	}
}
