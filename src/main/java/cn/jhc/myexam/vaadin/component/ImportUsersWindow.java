package cn.jhc.myexam.vaadin.component;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Component
@Scope("prototype")
public class ImportUsersWindow extends Window {

	private static final long serialVersionUID = 1L;
	
	private Upload upload;
	
	public ImportUsersWindow() {
		super("从Excel导入考生帐号");
		center();
		VerticalLayout layout = new VerticalLayout();
		layout.setImmediate(false);
		layout.setSizeUndefined();
		setContent(layout);
		upload = new Upload();
		upload.setButtonCaption("上传Excel文件");
		layout.addComponent(upload);
		layout.setComponentAlignment(upload, Alignment.MIDDLE_CENTER);
		
		setClosable(true);
		setModal(true);
		setResizable(false);
	}


}
