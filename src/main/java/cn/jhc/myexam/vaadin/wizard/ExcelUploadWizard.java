package cn.jhc.myexam.vaadin.wizard;

import org.vaadin.teemu.wizards.Wizard;
import org.vaadin.teemu.wizards.WizardStep;

import cn.jhc.myexam.vaadin.util.ExcelUploadHandler;
import cn.jhc.myexam.vaadin.util.PropertyData;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

public class ExcelUploadWizard<T> extends Wizard {
	
	private PropertyData propertyData = null;
	private Upload upload;
	private ExcelUploadHandler uploadHandler = null;
	
	public ExcelUploadWizard(Class<T> clazz, ExcelUploadHandler handler) {
		super();
		propertyData = new PropertyData(clazz);
		this.uploadHandler = handler;
		this.uploadHandler.setColumnNames(getImportColumns());
		this.addStep(new UploadExcelStep());
		
	}

	private String[] getImportColumns() {
		return propertyData.getDescriptionList().toArray(new String[0]);
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
			upload.addStartedListener(uploadHandler);
			upload.setReceiver(uploadHandler);
			upload.addSucceededListener(uploadHandler);
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
}
