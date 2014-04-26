package cn.jhc.myexam.vaadin.ui;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.context.SecurityContextHolder;

import cn.jhc.myexam.vaadin.ioc.Injector;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.shared.ui.MarginInfo;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Button.ClickListener;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.PasswordField;
import com.vaadin.ui.TextField;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class LoginUI extends UI implements ClickListener{

	private TextField usernameField;
	private PasswordField passwordField;
	private CheckBox rememberMeBox;

	@Autowired
	private transient AuthenticationManager authenticationManager;
	
	private final static String DEFAULT_TARGET_URL = "/dashboard/";
	
	@WebServlet(urlPatterns= {"/login/*"}, asyncSupported=true, 
			initParams = {@WebInitParam(name="UIProvider", value="cn.jhc.myexam.vaadin.ioc.AutowiredUIProvider")})
	@VaadinServletConfiguration(ui=LoginUI.class, productionMode=false)
	public static class Servlet extends VaadinServlet{
	}
	
	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("用户登陆");
		
//		authenticationManager = (AuthenticationManager) Injector.getApplicationContext().getBean("authenticationManager");
		
		VerticalLayout mainlLayout = new VerticalLayout();
		mainlLayout.setImmediate(false);
		setContent(mainlLayout);
		mainlLayout.setSizeFull();
		mainlLayout.setMargin(new MarginInfo(true, true, true, true));
		
		FormLayout loginLayout = new FormLayout();
		loginLayout.setWidth("300px");
		loginLayout.setCaption("用户登陆");
		usernameField = new TextField("用户名");
		loginLayout.addComponent(usernameField);
		passwordField = new PasswordField("密码");
		loginLayout.addComponent(passwordField);
		rememberMeBox = new CheckBox("记住登陆状态", false);
		loginLayout.addComponent(rememberMeBox);
		Button loginButton = new Button("登陆");
		loginLayout.addComponent(loginButton);
		mainlLayout.addComponent(loginLayout);
		mainlLayout.setComponentAlignment(loginLayout, Alignment.MIDDLE_CENTER);
		mainlLayout.setExpandRatio(loginLayout, 1.0f);
		loginButton.addClickListener(this);
	}

	@Override
	public void buttonClick(ClickEvent event) {
		String username = usernameField.getValue();
		String password = passwordField.getValue();
		try {
			UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(username, password);
			Authentication authentication = authenticationManager.authenticate(token);
			SecurityContextHolder.getContext().setAuthentication(authentication);
		} catch (AuthenticationException e) {
			Notification.show("认证失败：" + e.getMessage(), Notification.Type.WARNING_MESSAGE);
			return;
		}
		//login successed
		String rememberMeUrl = rememberMeBox.getValue() ? "?_spring_security_remember_me=true" : "";
		getPage().setLocation("/myexam" + DEFAULT_TARGET_URL + rememberMeUrl);
	}

}
