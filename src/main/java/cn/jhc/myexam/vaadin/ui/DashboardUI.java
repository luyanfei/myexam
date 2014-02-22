package cn.jhc.myexam.vaadin.ui;

import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
@Theme("dashboard")
public class DashboardUI extends UI {

	@WebServlet(urlPatterns= {"/dashboard/*"}, asyncSupported=true, 
			initParams = {@WebInitParam(name="UIProvider", value="cn.jhc.myexam.vaadin.ioc.AutowiredUIProvider")})
	@VaadinServletConfiguration(ui=DashboardUI.class, productionMode=false)
	public static class Servlet extends VaadinServlet{
	}
	
	@Override
	protected void init(VaadinRequest request) {
		checkNewUser();
		
	}

	/**
	 * If user is logged in by authentication provider other than system database, these user should be added to system.
	 */
	private void checkNewUser() {
		//TODO:
	}

}
