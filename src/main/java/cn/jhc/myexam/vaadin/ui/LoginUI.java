package cn.jhc.myexam.vaadin.ui;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.event.ShortcutAction.KeyCode;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.Panel;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginUI extends UI {

	private class LoginFormPanel extends Panel {
		public LoginFormPanel() {
			super("用户登录");
			setSizeUndefined();
			FormLayout layout = new FormLayout();
			layout.setMargin(true);
			setContent(layout);
			final TextField nameField = new TextField("用户名：");
			nameField.focus();
			layout.addComponent(nameField);
			final PasswordField passwordField = new PasswordField("密码：");
			layout.addComponent(passwordField);
			final Button okButton = new Button("登录");
			okButton.setClickShortcut(KeyCode.ENTER, null);
			okButton.addClickListener(new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					Notification.show("login user " + nameField.getValue());
				}
			});
			layout.addComponent(okButton);
		}
	}

	@WebServlet(urlPatterns= {"/login/*"}, asyncSupported=true, 
			initParams = {@WebInitParam(name="UIProvider", value="cn.jhc.myexam.vaadin.ioc.AutowiredUIProvider")})
	@VaadinServletConfiguration(ui=LoginUI.class, productionMode=false)
	public static class Servlet extends VaadinServlet{
	}
	
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		
		LoginFormPanel loginFormPanel = new LoginFormPanel();
		layout.addComponent(loginFormPanel);
		layout.setSizeFull();
		layout.setComponentAlignment(loginFormPanel, Alignment.MIDDLE_CENTER);
	}

}
