package cn.jhc.myexam.vaadin.component;

import java.util.ArrayList;
import java.util.List;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.service.UserService;
import cn.jhc.myexam.vaadin.ui.TeacherUI;
import cn.jhc.myexam.vaadin.util.Constants;
import cn.jhc.myexam.vaadin.view.UserManagerView;
import cn.jhc.myexam.vaadin.wizard.ExcelUploadWizard;
import cn.jhc.myexam.vaadin.wizard.SaveEntityListCallback;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class ImportUsersWindow extends Window {

	private final class SaveUserListCallback implements
			SaveEntityListCallback<User> {
		
		private List<User> failedList = new ArrayList<User>();
		
		@Override
		public void saveList(List<User> list) {
			UserManagerView userManagerView = ((TeacherUI)UI.getCurrent()).getUserManagerView();
			BeanContainer<Long,User> viewContainer = userManagerView.getContainer();
			for(User user : list) {
				try {
					userService.saveUser(user);
				} catch (Exception e) {
					e.printStackTrace();
					failedList.add(user);
					//不能成功添加的纪录不要添加到viewContainer中
					continue;
				}
				viewContainer.addItem(user.getId(), user);
			}
		}

		@Override
		public List<User> getFailedList() {
			return failedList;
		}
	}

	private static final long serialVersionUID = 1L;

	private transient UserService userService;

	public ImportUsersWindow(UserService service) {
		super("从Excel导入考生帐号");
		center();
		setId(Constants.ID_IMPORT_USERS_WINDOW);
		setHeight("400px");
		setWidth("600px");
		this.userService = service;
		SaveEntityListCallback<User> callback = new SaveUserListCallback();
		ExcelUploadWizard<User> wizard = new ExcelUploadWizard<User>(User.class, callback);

		setContent(wizard);
		
		setClosable(true);
		setModal(true);
		setResizable(false);
		//TODO: 底部留空，加点边框
	}

}
