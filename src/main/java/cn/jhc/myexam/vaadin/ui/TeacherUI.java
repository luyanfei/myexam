package cn.jhc.myexam.vaadin.ui;

import static cn.jhc.myexam.vaadin.util.NavigateItem.*;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import cn.jhc.myexam.vaadin.component.TeacherNavigator;
import cn.jhc.myexam.vaadin.view.MainView;
import cn.jhc.myexam.vaadin.view.QuestionsManagerView;
import cn.jhc.myexam.vaadin.view.UserManagerView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("myexam")
@Component
@Scope("prototype")
public class TeacherUI extends UI {
	
	private static final long serialVersionUID = 1L;
	@Autowired
	private MainView mainView;
	@Autowired
	private UserManagerView userManagerView;
	@Autowired
	private QuestionsManagerView questionsManagerView;
	
	@WebServlet(urlPatterns= {"/teacher/*"}, asyncSupported=true, 
			initParams = {@WebInitParam(name="UIProvider", value="cn.jhc.myexam.vaadin.ioc.AutowiredUIProvider")})
	@VaadinServletConfiguration(ui=TeacherUI.class, productionMode=false)
	public static class Servlet extends VaadinServlet{
	}

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("教师的管理窗口");
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setImmediate(false);
		horizontalLayout.setSizeFull();
		
		VerticalLayout mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setWidth("800px");
		mainLayout.setHeight("100%");
		
		horizontalLayout.addComponent(mainLayout);
		horizontalLayout.setComponentAlignment(mainLayout, Alignment.TOP_CENTER);
		setContent(horizontalLayout);
		
		mainLayout.addComponent(new TeacherNavigator());
		
		Panel panel = new Panel();
		mainLayout.addComponent(panel);
		panel.setWidth("100%");
		panel.setHeight("100%");
		mainLayout.setExpandRatio(panel, 1.0f);
		
		Navigator navigator = new Navigator(this, panel);
		navigator.addView(MAIN.toString(), mainView);
		navigator.addView(USERS.toString(), userManagerView);
		navigator.addView(QUESTIONS.toString(), questionsManagerView);
		
		navigator.navigateTo(MAIN.toString());
		
	}

	public UserManagerView getUserManagerView() {
		return userManagerView;
	}

}
