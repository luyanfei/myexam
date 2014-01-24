package cn.jhc.myexam.vaadin.factory;

import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;

public class EntityBuilderFactory {
	
	private static final Logger logger = Logger.getLogger(EntityBuilderFactory.class.getName());

	private static Map<String, VaadinEntityBuilder<?>> builders = new HashMap<String, VaadinEntityBuilder<?>>();
	
	public static <T> VaadinEntityBuilder<T> getEntityBuilder(Class<T> clazz){
		String className = clazz.getName();
		VaadinEntityBuilder<T> builder = null;
		try {
			builder = (VaadinEntityBuilder<T>) builders.get(className);
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return null;
		}
		if(builder == null) {
			builder = new VaadinEntityBuilder<T>(clazz);
			builders.put(className, builder);
		}
		return builder;
	}
}
