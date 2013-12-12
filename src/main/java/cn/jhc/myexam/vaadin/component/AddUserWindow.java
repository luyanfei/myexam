package cn.jhc.myexam.vaadin.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.service.UserService;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@Component @Scope("prototype")
public class AddUserWindow extends Window {

	private VerticalLayout mainLayout;
	
	@Autowired
	private transient UserService userService;
	
	//property name and form caption
	private final static String[][] userPropertyNames = new String[][]{
		{"username","准考证号"}, {"password","密码"}, {"enabled","是否启用"}, {"displayName","名字"}
	};

	private FormLayout formLayout;
	private User user;

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
		formLayout = new FormLayout();
		formLayout.setCaption("添加新的考生");
		formLayout.setStyleName("page-form");
		mainLayout.addComponent(formLayout);
		mainLayout.setComponentAlignment(formLayout, Alignment.MIDDLE_CENTER);
		
		formLayout.setMargin(true);
		final FieldGroup userFieldGroup = new BeanFieldGroup<User>(User.class);
		user = new User();
		userFieldGroup.setItemDataSource(new BeanItem<User>(user));
		for(String[] p : userPropertyNames){
			formLayout.addComponent(userFieldGroup.buildAndBind(p[1],p[0]));
		}
		
		Button okButton = new Button("保存");
		okButton.addClickListener(new Button.ClickListener() {
			
			private static final long serialVersionUID = 1L;

			@Override
			public void buttonClick(ClickEvent event) {
				try {
					userFieldGroup.commit();
				} catch (CommitException e) {
					e.printStackTrace();
				}
				userService.saveUser(user);
				Notification.show("添加考生成功");
				AddUserWindow.this.close();
			}
		});
		formLayout.addComponent(okButton);
	}

	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setMargin(true);
		return mainLayout;
	}

}
