package cn.jhc.myexam.vaadin.ui;

import static cn.jhc.myexam.vaadin.util.NavigateItem.*;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.jhc.myexam.vaadin.component.TeacherNavigator;
import cn.jhc.myexam.vaadin.view.AddUserView;
import cn.jhc.myexam.vaadin.view.ImportUsersView;
import cn.jhc.myexam.vaadin.view.MainView;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Panel;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@Theme("myexamtheme")
@Component
public class TeacherUI extends UI {
	
	@Autowired
	private MainView mainView;
	
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
		
		horizontalLayout.addComponent(mainLayout);
		horizontalLayout.setComponentAlignment(mainLayout, Alignment.TOP_CENTER);
		setContent(horizontalLayout);
		
		mainLayout.addComponent(new TeacherNavigator());
		
		Panel panel = new Panel();
		mainLayout.addComponent(panel);
		panel.setWidth("100%");
		panel.setHeight("100%");
		
		Navigator navigator = new Navigator(this, panel);
		navigator.addView(main.toString(), mainView);

		
		navigator.navigateTo(main.toString());
		
	}

}
