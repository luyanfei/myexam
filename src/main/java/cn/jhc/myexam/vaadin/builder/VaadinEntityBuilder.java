package cn.jhc.myexam.vaadin.builder;

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

public class VaadinEntityBuilder<T> {
	
	private List<String> propertyNameList;
	private List<String> descriptionList;
	private Class<T> theClass;

	public static interface DeleteCallback<T> {
		public void onDelete(T delItem);
	}
	
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

	public Table getEntityTable(Collection<T> collection, 
			final DeleteCallback<T> callback) {
		Table table = buildTable(collection);
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
