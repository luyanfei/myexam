package cn.jhc.myexam.vaadin.util;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.lang.reflect.Field;
import java.util.Collection;

import javax.persistence.Entity;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Table;

public class EntityTableFactory {
	
	public static <T> Table getEntityTable(Class<T> clazz, Collection<T> collection) {
		Entity entityAnnotation = clazz.getAnnotation(Entity.class);
		if(entityAnnotation == null)
			throw new IllegalArgumentException("clazz must has @Entity annotation.");
		BeanContainer<Long, T> container = new BeanContainer<Long, T>(clazz);
		container.setBeanIdProperty("id");
		container.addAll(collection);
		//TODO: inotrospector get all visible ids

		for(Field field : clazz.getFields()) {
			
		}
		
		return null;
	}
}
