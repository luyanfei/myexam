package cn.jhc.myexam.vaadin.window;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.service.UserService;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder.EntityFormOkCallback;
import cn.jhc.myexam.vaadin.ui.TeacherUI;
import cn.jhc.myexam.vaadin.view.UserManagerView;

import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Component @Scope("prototype")
public class AddUserWindow extends Window {

	private static final Logger logger = Logger.getLogger(AddUserWindow.class.getName());
	
	private VerticalLayout mainLayout;
	
	@Autowired
	private transient UserService userService;

	private FormLayout formLayout;
	
	private static final long serialVersionUID = 1L;
	
	public AddUserWindow() {
		super("添加新的考生");
		center();
		buildMainLayout();
		setContent(mainLayout);

		buildFormLayout();
		
		setClosable(true);
		setModal(true);
		setResizable(false);
	}

	private void buildFormLayout() {
		formLayout = VaadinEntityBuilder.create(User.class)
				.buildFormLayout("添加新的考生", new EntityFormOkCallback<User>() {

			@Override
			public void onSave(User item) {
				try {
					userService.saveUser(item);
				} catch (Throwable t) {
					logger.severe(t.getMessage());
					return;
				}
				UserManagerView userManagerView = ((TeacherUI)UI.getCurrent()).getUserManagerView();
				BeanItemContainer<User> container = userManagerView.getContainer();
				container.addItem(item);
				Notification.show("添加考生成功");
				AddUserWindow.this.close();
			}
		});

		mainLayout.addComponent(formLayout);
		mainLayout.setComponentAlignment(formLayout, Alignment.MIDDLE_CENTER);

	}

	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setMargin(true);
		return mainLayout;
	}

}
