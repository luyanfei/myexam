package cn.jhc.myexam.vaadin.view;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.service.UserService;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanItem;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Button.ClickEvent;

@Component
@Scope("prototype")
public class AddUserView extends CustomComponent implements View{

	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */

	@AutoGenerated
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
	
	/**
	 * The constructor should first build the main layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public AddUserView() {
		buildMainLayout();
		setCompositionRoot(mainLayout);

		buildFormLayout();
	}

	private void buildFormLayout() {
		formLayout = new FormLayout();
		formLayout.setCaption("添加新的考生");
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
				user = new User();
				userFieldGroup.setItemDataSource(new BeanItem<User>(user));
				Notification.show("添加考生成功");
			}
		});
		formLayout.addComponent(okButton);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

	@AutoGenerated
	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		return mainLayout;
	}

}