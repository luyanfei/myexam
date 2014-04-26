package cn.jhc.myexam.vaadin.ioc;

import javax.servlet.ServletContext;

import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.context.support.WebApplicationContextUtils;

public class Injector {

	public static void inject(Object component) {
		AutowireCapableBeanFactory beanFactory = getApplicationContext().getAutowireCapableBeanFactory();
		beanFactory.autowireBean(component);
	}
	
	public static ApplicationContext getApplicationContext() {
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.currentRequestAttributes();
		ServletContext context = attributes.getRequest().getSession(false).getServletContext();
		return WebApplicationContextUtils.getRequiredWebApplicationContext(context);
	}
	
	public static Object getBean(String name) {
		return getApplicationContext().getBean(name);
	}
}
