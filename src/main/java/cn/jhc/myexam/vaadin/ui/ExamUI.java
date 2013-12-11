package cn.jhc.myexam.vaadin.ui;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import com.vaadin.annotations.Theme;
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

@Theme("myexamtheme")
@SuppressWarnings("serial")
public class ExamUI extends UI {

	public class LoginForm extends FormLayout{
		private TextField nameField;
		private PasswordField passwordField;
		private Button okButton;

		public LoginForm() {
			setMargin(true);
			nameField = new TextField("用户名：");
			nameField.focus();
			addComponent(nameField);
			passwordField = new PasswordField("密码：");
			addComponent(passwordField);
			okButton = new Button("登录");
			okButton.setClickShortcut(KeyCode.ENTER, null);
			okButton.addClickListener(new Button.ClickListener() {
				
				@Override
				public void buttonClick(ClickEvent event) {
					Notification.show("login user " + nameField.getValue());
				}
			});
			addComponent(okButton);
		}

		public TextField getNameField() {
			return nameField;
		}

		public PasswordField getPasswordField() {
			return passwordField;
		}
	}

	@WebServlet(urlPatterns= {"/exam/*"}, asyncSupported=true, 
			initParams = {@WebInitParam(name="UIProvider", value="cn.jhc.myexam.vaadin.ioc.AutowiredUIProvider")})
	@VaadinServletConfiguration(ui=ExamUI.class, productionMode=false)
	public static class Servlet extends VaadinServlet{
	}
	
	@Override
	protected void init(VaadinRequest request) {
		VerticalLayout layout = new VerticalLayout();
		setContent(layout);
		
		Panel loginPanel = new Panel("用户登录");
		loginPanel.setSizeUndefined();
		LoginForm loginForm = new LoginForm();
		loginPanel.setContent(loginForm);
		layout.addComponent(loginPanel);
		layout.setSizeFull();
		layout.setComponentAlignment(loginPanel, Alignment.MIDDLE_CENTER);
	}

}
