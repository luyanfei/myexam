package cn.jhc.myexam.vaadin.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.service.UserService;
import cn.jhc.myexam.server.service.UserServiceImpl;
import cn.jhc.myexam.vaadin.ioc.Injector;
import cn.jhc.myexam.vaadin.ui.TeacherUI;
import cn.jhc.myexam.vaadin.view.UserManagerView;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.shared.ui.label.ContentMode;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

class ImportUsersCommitButtonListener implements ClickListener {

	private static final long serialVersionUID = 1L;

	private transient UserService userService;
	
	private com.vaadin.ui.Table table;
	
	ImportUsersCommitButtonListener(com.vaadin.ui.Table table) {
		this.table = table;
		this.userService = (UserService)Injector.getApplicationContext().getBean(UserServiceImpl.class);
	}
	
	@Override
	public void buttonClick(ClickEvent event) {
		UserManagerView userManagerView = ((TeacherUI)UI.getCurrent()).getUserManagerView();
		BeanContainer<Long,User> viewContainer = userManagerView.getContainer();
		List<User> failedList = new ArrayList<User>();
		@SuppressWarnings("unchecked")
		final BeanItemContainer<User> c = (BeanItemContainer<User>)table.getContainerDataSource();
		Collection<?> ids = c.getItemIds();
		for(Object id : ids) {
			User user = c.getItem(id).getBean();
			try {
				userService.saveUser(user);
			} catch (Exception e) {
				// 记录没有成功的记录
				failedList.add(user);
				//不能成功添加的纪录不要添加到viewContainer中
				continue;
			}
			viewContainer.addItem(user.getId(), user);
		}
		int failed = failedList.size();
		int successed = ids.size() - failed;
		// 显示添加结果
		final Window window = WindowUtils.findWindowById(Constants.ID_IMPORT_USERS_WINDOW);
		VerticalLayout layout = new VerticalLayout();
		layout.setImmediate(false);
		layout.setMargin(true);
		layout.setSpacing(true);
		Label label = new Label("本次操作向服务器成功添加了" + successed +"条考生纪录。");
		layout.addComponent(label);
		if(failed > 0) {
			StringBuilder builder = new StringBuilder();
			for(User u : failedList)
				builder.append("<li>" + u.getDisplayName() + "," + u.getUsername() + "</li>");
			Label label2 = new Label("其中" + failed + "条纪录无法成功添加，具体是：<br/>"
					+ "<ul>" + builder + "</ul>", ContentMode.HTML);
			layout.addComponent(label2);
		}
		Button okButton = new Button("确认");
		layout.addComponent(okButton);
		okButton.addClickListener(new Button.ClickListener() {
			
			@Override
			public void buttonClick(ClickEvent event) {
				UI.getCurrent().removeWindow(window);
				//TODO: 刷新考生管理界面的table的数据

			}
		});
		window.setContent(layout);
		window.center();
	}

}