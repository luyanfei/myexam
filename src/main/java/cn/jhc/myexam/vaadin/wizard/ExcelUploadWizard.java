package cn.jhc.myexam.vaadin.wizard;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
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
import org.springframework.beans.BeansException;
import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import cn.jhc.myexam.vaadin.util.Constants;
import cn.jhc.myexam.vaadin.util.PropertyData;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.Component;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Upload;
import com.vaadin.ui.Notification.Type;
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
	private String[] columnNames = null;
	private Class<T> theClass = null;
	
	public ExcelUploadWizard(Class<T> clazz) {
		super();
		this.theClass = clazz;
		propertyData = new PropertyData(clazz);
		this.columnNames = propertyData.getDescriptionList().toArray(new String[0]);
		this.addStep(new UploadExcelStep());
		this.addStep(new ConfirmImportStep());
	}

	private String getCommaSeperatedImportColumns() {
		StringBuilder sb = new StringBuilder();
		for(String s : propertyData.getImportColumnList())
			sb.append(s).append("，");
		if(sb.length() > 0)
			sb.deleteCharAt(sb.length() - 1);
		return sb.toString();
	}
	
	private class UploadExcelStep implements WizardStep{

		@Override
		public String getCaption() {
			return "选择Excel文件";
		}

		@Override
		public Component getContent() {
			VerticalLayout layout = new VerticalLayout();
			layout.setImmediate(false);
			layout.setSizeUndefined();
			layout.setSpacing(true);
			
			Label infoLabel = new Label("<h2>上传注意事项</h2>"
					+ "<ul><li>文件的后缀必须是.xls或.xlsx。</li>"
					+ "<li>文件的大小不能超过5MB。</li>"
					+ "<li>服务器只会解析第1个工作表，其它工作表中的数据会被忽略。</li>"
					+ "<li>第1个工作表的第1行必须是表头，表头中的列名分别为\"" 
						+ getCommaSeperatedImportColumns() + "\"（次序无关）。</li>"
					+ "<li>服务器只解析第1列和第2列的数据，忽略第3列及以后的数据。</li></ul><br/>",
					ContentMode.HTML);
			layout.addComponent(infoLabel);
			buildUpload();
			layout.addComponent(upload);
			layout.setComponentAlignment(upload, Alignment.MIDDLE_CENTER);
			return null;
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
			return false;
		}

		@Override
		public boolean onBack() {
			return false;
		}
	}
	
	private class ConfirmImportStep implements WizardStep {
		private VerticalLayout mainLayout;
		private CheckBox editableCheckBox;
		private com.vaadin.ui.Table table;
		private Button commitButton;
		@Override
		public String getCaption() {
			return "确认上传的数据";
		}

		@Override
		public Component getContent() {
			this.table = new com.vaadin.ui.Table();
			
			mainLayout = new VerticalLayout();
			mainLayout.setImmediate(false);
			mainLayout.setSizeUndefined();
			mainLayout.setSpacing(true);
			mainLayout.setMargin(true);
			setCompositionRoot(mainLayout);
			
			table.setStyleName("page-table");
			table.setCaption("将要添加的纪录");
			table.setImmediate(false);
			table.setWidth("700px");
			table.setHeight("-1px");
			table.setPageLength(Constants.TABLE_PAGE_SIZE);
			mainLayout.addComponent(table);

			buildOperationsLayout();
			return mainLayout;
		}
		
		private void buildOperationsLayout() {
			HorizontalLayout horizontalLayout = new HorizontalLayout();
			horizontalLayout.setImmediate(false);
			horizontalLayout.setWidth("100%");
			
			commitButton = new Button("添加所有纪录");
			horizontalLayout.addComponent(commitButton);
			horizontalLayout.setComponentAlignment(commitButton, Alignment.MIDDLE_LEFT);
			
			editableCheckBox = new CheckBox("打开编辑模式", false);
			horizontalLayout.addComponent(editableCheckBox);
			horizontalLayout.setComponentAlignment(editableCheckBox, Alignment.MIDDLE_RIGHT);
			editableCheckBox.addValueChangeListener(new ValueChangeListener() {
				
				@Override
				public void valueChange(ValueChangeEvent event) {
					table.setEditable(editableCheckBox.getValue());
				}
			});
			
			mainLayout.addComponent(horizontalLayout);
		}

		@Override
		public boolean onAdvance() {
			return false;
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
		List<T> importList = buildImportList(context);
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
					wrapper.setPropertyValue(columnNames[i], (String) row.getValue(columns[i]));
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
