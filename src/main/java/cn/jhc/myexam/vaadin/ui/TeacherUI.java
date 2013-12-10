package cn.jhc.myexam.vaadin.ui;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.navigator.Navigator;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.HorizontalSplitPanel;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

@Component
public class TeacherUI extends UI {
	
	@Autowired
	private TeacherNavigator teacherMenu;
	private HorizontalSplitPanel splitPanel;
	
	@WebServlet(urlPatterns= {"/teacher/*"}, asyncSupported=true, 
			initParams = {@WebInitParam(name="UIProvider", value="cn.jhc.myexam.vaadin.ioc.AutowiredUIProvider")})
	@VaadinServletConfiguration(ui=TeacherUI.class, productionMode=false)
	public static class Servlet extends VaadinServlet{
	}

	@Override
	protected void init(VaadinRequest request) {
		getPage().setTitle("教师的管理窗口");
		splitPanel = new HorizontalSplitPanel();
		setContent(splitPanel);
		splitPanel.setLocked(true);
		splitPanel.setSplitPosition(15, Unit.PERCENTAGE);
		splitPanel.addComponent(teacherMenu);
		splitPanel.addComponent(new Label("欢迎"));
		
	}

}
