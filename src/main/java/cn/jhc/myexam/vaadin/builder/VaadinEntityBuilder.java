package cn.jhc.myexam.vaadin.builder;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

import javax.persistence.Entity;

import cn.jhc.myexam.vaadin.util.Constants;
import cn.jhc.myexam.vaadin.util.PropertyData;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.DefaultFieldGroupFieldFactory;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.fieldgroup.FieldGroupFieldFactory;
import com.vaadin.data.util.BeanItem;
import com.vaadin.data.util.BeanItemContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Field;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnHeaderMode;
import com.vaadin.ui.TextField;

/**
 * This class is used to build vaadin component from Entity class.
 * @author luyanfei
 * @param <T>
 * 		Entity type.
 */
public class VaadinEntityBuilder<T> {
	
	private PropertyData data = null;
	private Class<T> theClass;
	private static final Map<String, VaadinEntityBuilder<?>> builders = new ConcurrentHashMap<String, VaadinEntityBuilder<?>>();
	private final static Logger logger = Logger.getLogger(VaadinEntityBuilder.class.getName());
	
	private static final class EntityFormOkListener<T> implements
			Button.ClickListener {
		private final FieldGroup fieldGroup;
		private final EntityFormCallback<T> callback;
		private final T item;
		private static final long serialVersionUID = 1L;

		private EntityFormOkListener(FieldGroup userFieldGroup,
				EntityFormCallback<T> callback, T item) {
			this.fieldGroup = userFieldGroup;
			this.callback = callback;
			this.item = item;
		}

		@Override
		public void buttonClick(ClickEvent event) {
			try {
				fieldGroup.commit();
			} catch (CommitException e) {
				e.printStackTrace();
				logger.severe(e.getMessage());
				return;
			}
			callback.onSave(item);
		}
	}

	public static interface EntityFormCallback<E> extends Serializable{
		public void onSave(E item);
		public void addCustomField(FormLayout formLayout, FieldGroup fieldGroup);
	}

	public VaadinEntityBuilder(Class<T> clazz){
		Entity entityAnnotation = clazz.getAnnotation(Entity.class);
		if(entityAnnotation == null)
			throw new IllegalArgumentException("clazz must has @Entity annotation.");
		this.theClass = clazz;
		this.data = PropertyData.create(clazz);
	}

	public BeanItemContainer<T> buildContainer(Collection<T> collection) {
		BeanItemContainer<T> container = new BeanItemContainer<T>(theClass);
		container.addAll(collection);
		return container;
	}
	
	/**
	 * Build vaadin table from entity collection.
	 * @param collection
	 * 		collection of entity objects.
	 * @return
	 * 		vaadin table.
	 */
	public Table buildTable(Collection<T> collection) {
		Table table = new Table();
		table.setContainerDataSource(buildContainer(collection), data.getPropertyNameList());
		table.setColumnHeaderMode(ColumnHeaderMode.EXPLICIT);
		table.setColumnHeaders(data.getDescriptionList().toArray(new String[0]));
		return table;
	}
	
	public Table modifyTable(Table table, BeanItemContainer<?> container) {
		table.setContainerDataSource(container, data.getPropertyNameList());
		table.setColumnHeaderMode(ColumnHeaderMode.EXPLICIT);
		table.setColumnHeaders(data.getDescriptionList().toArray(new String[0]));
		return table;
	}
	
	/**
	 * Build FormLayout from Entity.
	 * @param caption
	 * 		FormLayout's caption.
	 * @param callback
	 * 		after FieldGroup is committed, the function in this callback will be invoked. 
	 * @return
	 * 		FormLayout object which can be used in Window or layout component.
	 */
	public FormLayout buildFormLayout(String caption, final EntityFormCallback<T> callback) {
		FormLayout formLayout = new FormLayout();
		formLayout.setCaption(caption);
		formLayout.setStyleName(Constants.STYLE_ADD_ENTITY_FORM);
		
		formLayout.setMargin(true);
		final FieldGroup fieldGroup = new BeanFieldGroup<T>(theClass);
		T item = null;
		try {
			item = theClass.newInstance();
		} catch (Exception e) {
			logger.severe(e.getMessage());
			return null;
		} 
		fieldGroup.setItemDataSource(new BeanItem<T>(item));
		for(int i = 0; i<data.getPropertyNameList().size(); i++){
			Field<?> field = fieldGroup.buildAndBind(data.getDescriptionList().get(i), data.getPropertyNameList().get(i));
			if(field instanceof TextField)
				((TextField)field).setNullRepresentation("");
			formLayout.addComponent(field);
		}
		//After @Description processing
		callback.addCustomField(formLayout, fieldGroup);
		
		Button okButton = new Button("保存");
		okButton.addClickListener(new EntityFormOkListener<T>(fieldGroup, callback, item));
		formLayout.addComponent(okButton);
		return formLayout;
	}

	public List<String> getPropertyNameList() {
		return data.getPropertyNameList();
	}

	public List<String> getDescriptionList() {
		return data.getDescriptionList();
	}

	public static <T> VaadinEntityBuilder<T> create(Class<T> clazz){
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
