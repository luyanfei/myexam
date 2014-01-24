package cn.jhc.myexam.vaadin.builder;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import cn.jhc.myexam.annotation.Description;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnHeaderMode;

public class VaadinEntityBuilder<T> {
	
	private List<String> propertyNameList;
	private List<String> descriptionList;
	private Class<T> theClass;

	public VaadinEntityBuilder(Class<T> clazz){
		Entity entityAnnotation = clazz.getAnnotation(Entity.class);
		if(entityAnnotation == null)
			throw new IllegalArgumentException("clazz must has @Entity annotation.");
		this.theClass = clazz;
		propertyNameList = new ArrayList<String>();
		descriptionList = new ArrayList<String>();
		for(Field field : clazz.getDeclaredFields()) {
			Description description = field.getAnnotation(Description.class);
			if(description != null) {
				propertyNameList.add(field.getName());
				descriptionList.add(description.value());
			}
		}
	}

	/**
	 * Build vaadin table from entity collection.
	 * @param collection
	 * 		collection of entity objects.
	 * @return
	 * 		vaadin table.
	 */
	public Table buildTable(Collection<T> collection) {

		BeanContainer<Long, T> container = new BeanContainer<Long, T>(theClass);
		container.setBeanIdProperty("id");
		container.addAll(collection);

		Table table = new Table();
		table.setContainerDataSource(container, propertyNameList);
		table.setColumnHeaderMode(ColumnHeaderMode.EXPLICIT);
		table.setColumnHeaders(descriptionList.toArray(new String[0]));
		return table;
	}
}
