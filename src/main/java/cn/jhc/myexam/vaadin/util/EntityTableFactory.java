package cn.jhc.myexam.vaadin.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;

import cn.jhc.myexam.annotation.Description;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnHeaderMode;
import com.vaadin.ui.themes.BaseTheme;

public class EntityTableFactory {
	
	public static interface DeleteCallback<T> {
		public void onDelete(T delItem);
	}
	
	/**
	 * 
	 * @param clazz
	 * 		entity class beneath the table.
	 * @param collection
	 * 		collection of entity objects.
	 * @return
	 * 		the constructed vaadin table.
	 */
	public static <T> Table getEntityTable(Class<T> clazz, Collection<T> collection) {
		Entity entityAnnotation = clazz.getAnnotation(Entity.class);
		if(entityAnnotation == null)
			throw new IllegalArgumentException("clazz must has @Entity annotation.");
		BeanContainer<Long, T> container = new BeanContainer<Long, T>(clazz);
		container.setBeanIdProperty("id");
		container.addAll(collection);
		List<String> propertyNameList = new ArrayList<String>();
		List<String> descriptionList = new ArrayList<String>();
		for(Field field : clazz.getDeclaredFields()) {
			Description description = field.getAnnotation(Description.class);
			if(description != null) {
				propertyNameList.add(field.getName());
				descriptionList.add(description.value());
			}
		}
		Table table = new Table();
		table.setContainerDataSource(container, propertyNameList);
		table.setColumnHeaderMode(ColumnHeaderMode.EXPLICIT);
		table.setColumnHeaders(descriptionList.toArray(new String[0]));
		return table;
	}
	
	/**
	 * 
	 * @param clazz
	 * 		entity class beneath the table.
	 * @param collection
	 * 		collection of entity objects.
	 * @param callback
	 * 		delete callback for item deleting.
	 * @return
	 * 		the constructed vaadin table.
	 */
	public static <T> Table getEntityTable(Class<T> clazz, Collection<T> collection, 
			final DeleteCallback<T> callback) {
		Table table = getEntityTable(clazz, collection);
		table.addGeneratedColumn("delete", new Table.ColumnGenerator() {
			
			@Override
			public Object generateCell(final Table source, final Object itemId, Object columnId) {
				Button removeButton = new Button("删除");
				removeButton.setStyleName(BaseTheme.BUTTON_LINK);
				removeButton.addClickListener(new Button.ClickListener() {
					
					@Override
					public void buttonClick(ClickEvent event) {
						BeanContainer<Long, T> bc = (BeanContainer<Long, T>)source.getContainerDataSource();
						T delItem = bc.getItem(itemId).getBean(); 
						source.removeItem(itemId);
						callback.onDelete(delItem);
					}
				});
				return removeButton;
			}
		});
		return table;
	}
}
