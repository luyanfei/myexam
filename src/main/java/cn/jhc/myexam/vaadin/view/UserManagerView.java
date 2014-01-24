package cn.jhc.myexam.vaadin.view;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.service.UserService;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.component.AddUserWindow;
import cn.jhc.myexam.vaadin.component.ImportUsersWindow;
import cn.jhc.myexam.vaadin.factory.EntityBuilderFactory;
import cn.jhc.myexam.vaadin.ioc.Injector;
import cn.jhc.myexam.vaadin.util.Constants;
import cn.jhc.myexam.vaadin.util.TableUtils;

import com.vaadin.annotations.AutoGenerated;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Table;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Component @Scope("prototype") @SuppressWarnings("serial")
public class UserManagerView extends CustomComponent implements View{

	@AutoGenerated
	private VerticalLayout mainLayout;

	@AutoGenerated
	private HorizontalLayout horizontalLayout;

	@AutoGenerated
	private NativeButton importUsersButton;

	@AutoGenerated
	private NativeButton addUserButton;

	@AutoGenerated
	private Table usersTable;

	@Autowired
	private AddUserWindow addUserWindow;

	private transient UserService userService;
	
	/*- VaadinEditorProperties={"grid":"RegularGrid,20","showGrid":true,"snapToGrid":true,"snapToObject":true,"movingGuides":false,"snappingDistance":10} */
	
	/**
	 * The constructor should first build the MAIN layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	@Autowired
	public UserManagerView(UserService theUserService) {
		this.userService = theUserService;
		
		List<User> list = userService.findAllUsers();
		TableUtils.DeleteCallback<User> deleteCallback = 
				new TableUtils.DeleteCallback<User>() {

					@Override
					public void onDelete(User delItem) {
						String info = delItem.getId() + "(" + delItem.getDisplayName() + ")";
						userService.deleteUser(delItem);
						Notification.show("成功删除用户" + info);
					}
				};
		usersTable = EntityBuilderFactory.getEntityBuilder(User.class).buildTable(list);
		TableUtils.addDeleteColumn(usersTable, deleteCallback); 
		
		buildMainLayout();
		setCompositionRoot(mainLayout);

		usersTable.setSelectable(true);
		usersTable.setPageLength(Constants.TABLE_PAGE_SIZE);

		addUserButton.addClickListener(new ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().addWindow(addUserWindow);
			}
		});
		
		importUsersButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				ImportUsersWindow importUsersWindow = Injector.getApplicationContext()
						.getBean(ImportUsersWindow.class);
				UI.getCurrent().addWindow(importUsersWindow);
			}
		});
		
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("100%");
		mainLayout.setHeight("100%");
		mainLayout.setMargin(false);
		mainLayout.setSpacing(true);
		
		// top-level component properties
		setWidth("100.0%");
		setHeight("100.0%");
		
		// usersTable
		usersTable.setStyleName("page-table");
		usersTable.setCaption("考生列表");
		usersTable.setImmediate(false);
		usersTable.setWidth("100.0%");
		usersTable.setHeight("-1px");
		mainLayout.addComponent(usersTable);
		
		// horizontalLayout
		horizontalLayout = buildHorizontalLayout();
		mainLayout.addComponent(horizontalLayout);
		
		return mainLayout;
	}

	@AutoGenerated
	private HorizontalLayout buildHorizontalLayout() {
		// common part: create layout
		horizontalLayout = new HorizontalLayout();
		horizontalLayout.setImmediate(false);
		horizontalLayout.setWidth("-1px");
		horizontalLayout.setHeight("40px");
		horizontalLayout.setMargin(false);
		horizontalLayout.setSpacing(true);
		
		// addUserButton
		addUserButton = new NativeButton();
		addUserButton.setStyleName("page-button");
		addUserButton.setCaption("添加考生");
		addUserButton.setImmediate(true);
		addUserButton.setDescription("点击这里可以添加单个考生");
		addUserButton.setWidth("-1px");
		addUserButton.setHeight("100.0%");
		horizontalLayout.addComponent(addUserButton);
		horizontalLayout
				.setComponentAlignment(addUserButton, new Alignment(48));
		
		// importUsersButton
		importUsersButton = new NativeButton();
		importUsersButton.setStyleName("page-button");
		importUsersButton.setCaption("从Excel导入多位考生");
		importUsersButton.setImmediate(true);
		importUsersButton.setDescription("点击这里可以从Excel中导入多个考生");
		importUsersButton.setWidth("-1px");
		importUsersButton.setHeight("100.0%");
		horizontalLayout.addComponent(importUsersButton);
		horizontalLayout.setComponentAlignment(importUsersButton,
				new Alignment(48));
		
		return horizontalLayout;
	}

	public BeanContainer<Long, User> getContainer() {
		return (BeanContainer<Long, User>) usersTable.getContainerDataSource();
	}

}
