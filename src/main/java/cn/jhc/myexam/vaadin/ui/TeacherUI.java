package cn.jhc.myexam.vaadin.ui;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

public class TeacherUI extends UI {
	
	private TeacherMenu teacherMenu = new TeacherMenu();
	
	@WebServlet(urlPatterns= {"/teacher/*"}, asyncSupported=true, 
			initParams = {@WebInitParam(name="UIProvider", value="cn.jhc.myexam.vaadin.ioc.AutowiredUIProvider")})
	@VaadinServletConfiguration(ui=TeacherUI.class, productionMode=false)
	public static class Servlet extends VaadinServlet{
	}

	@Override
	protected void init(VaadinRequest request) {
		HorizontalSplitPanel hsPanel = new HorizontalSplitPanel();
		setContent(hsPanel);
		hsPanel.setLocked(true);
		hsPanel.setSplitPosition(15, Unit.PERCENTAGE);
		hsPanel.addComponent(teacherMenu);
		hsPanel.addComponent(new Label("欢迎"));
		
	}

}
