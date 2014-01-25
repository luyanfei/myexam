package cn.jhc.myexam.vaadin.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.vaadin.util.Constants;
import cn.jhc.myexam.vaadin.util.ExcelUploadHandler;
import cn.jhc.myexam.vaadin.wizard.ExcelUploadWizard;

import com.vaadin.ui.Window;

@Component
@Scope("prototype")
public class ImportUsersWindow extends Window {

	private static final long serialVersionUID = 1L;

	@Autowired
	public ImportUsersWindow(ExcelUploadHandler uploadHandler) {
		super("从Excel导入考生帐号");
		center();
		setId(Constants.ID_IMPORT_USERS_WINDOW);
		ExcelUploadWizard<User> wizard = new ExcelUploadWizard<User>(User.class, uploadHandler);

		setContent(wizard);
		
		setClosable(true);
		setModal(true);
		setResizable(false);
		//TODO: 底部留空，加点边框
	}

}
