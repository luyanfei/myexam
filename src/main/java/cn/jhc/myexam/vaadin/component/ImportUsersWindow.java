package cn.jhc.myexam.vaadin.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.jhc.myexam.vaadin.util.Constants;
import cn.jhc.myexam.vaadin.util.ExcelFileUploadHandler;
import cn.jhc.myexam.vaadin.util.ImportUsersExcelFileUploadHandler;

import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Label;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Component
@Scope("prototype")
public class ImportUsersWindow extends Window {

	private static final long serialVersionUID = 1L;

	private ExcelFileUploadHandler excelFileUploadHandler = new ImportUsersExcelFileUploadHandler();
	
	private Upload upload;

	public static final String USERNAME = "准考证号";

	public static final String DISPLAYNAME = "姓名";
	
	public ImportUsersWindow() {
		super("从Excel导入考生帐号");
		center();
		setId(Constants.ID_IMPORT_USERS_WINDOW);
		VerticalLayout layout = new VerticalLayout();
		layout.setImmediate(false);
		layout.setSizeUndefined();
		layout.setSpacing(true);
		setContent(layout);
		
		Label infoLabel = new Label("<h2>上传注意事项</h2>"
				+ "<ul><li>文件的后缀必须是.xls或.xlsx。</li>"
				+ "<li>文件的大小不能超过5MB。</li>"
				+ "<li>服务器只会解析第1个工作表，其它工作表中的数据会被忽略。</li>"
				+ "<li>第1个工作表的第1行必须是表头，表头中的列名分别为\"" 
					+ USERNAME + "\"和\"" + DISPLAYNAME + "\"（次序无关）。</li>"
				+ "<li>服务器只解析第1列和第2列的数据，忽略第3列及以后的数据。</li></ul><br/>",
				ContentMode.HTML);
		layout.addComponent(infoLabel);
		buildUpload();
		layout.addComponent(upload);
		layout.setComponentAlignment(upload, Alignment.MIDDLE_CENTER);
		
		setClosable(true);
		setModal(true);
		setResizable(false);
		//TODO: 底部留空，加点边框
	}

	private void buildUpload() {
		upload = new Upload();
		upload.setButtonCaption("上传Excel文件");
		upload.addStartedListener(excelFileUploadHandler);
		upload.setReceiver(excelFileUploadHandler);
		upload.addSucceededListener(excelFileUploadHandler);
	}


}
