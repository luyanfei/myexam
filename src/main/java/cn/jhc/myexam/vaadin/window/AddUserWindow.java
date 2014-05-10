package cn.jhc.myexam.vaadin.window;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.service.UserService;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder.EntityFormCallback;
import cn.jhc.myexam.vaadin.view.UserManagerView;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;

public class AddUserWindow extends FormWindow{

	private static final Logger logger = Logger.getLogger(AddUserWindow.class.getName());

	private transient UserService userService;
	
	private static final long serialVersionUID = 1L;
	
	private UserManagerView userManagerView;
	
	public AddUserWindow(UserManagerView userManagerView, UserService userService) {
		this.userManagerView = userManagerView;
		this.userService = userService;
		setCaption("添加新的考生");
	}

	protected FormLayout buildFormLayout() {
		FormLayout formLayout = VaadinEntityBuilder.create(User.class)
				.buildFormLayout("添加新的考生", new EntityFormCallback<User>() {

			@Override
			public void onSave(User item) {
				try {
					userService.saveUser(item);
				} catch (Throwable t) {
					logger.severe(t.getMessage());
					t.printStackTrace();
					return;
				}
				BeanItemContainer<User> container = userManagerView.getContainer();
				container.addItem(item);
				Notification.show("添加考生成功！");
				AddUserWindow.this.close();
			}

			@Override
			public void addCustomField(FormLayout formLayout,
					FieldGroup fieldGroup) {
			}
		});

		return formLayout;
	}

}
