package cn.jhc.myexam.vaadin.builder;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.logging.Logger;

import javax.persistence.Entity;

import cn.jhc.myexam.vaadin.util.Constants;
import cn.jhc.myexam.vaadin.util.PropertyData;

import com.vaadin.data.fieldgroup.BeanFieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.data.fieldgroup.FieldGroup.CommitException;
import com.vaadin.data.util.BeanContainer;
import com.vaadin.data.util.BeanItem;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.Table.ColumnHeaderMode;

/**
 * This class is used to build vaadin component from Entity class.
 * @author luyanfei
 * @param <T>
 * 		Entity type.
 */
public class VaadinEntityBuilder<T> {
	
	private PropertyData data = null;
	private Class<T> theClass;
	private final static Logger logger = Logger.getLogger(VaadinEntityBuilder.class.getName());
	
	private static final class EntityFormOkListener<T> implements
			Button.ClickListener {
		private final FieldGroup fieldGroup;
		private final EntityFormOkCallback<T> callback;
		private final T item;
		private static final long serialVersionUID = 1L;

		private EntityFormOkListener(FieldGroup userFieldGroup,
				EntityFormOkCallback<T> callback, T item) {
			this.fieldGroup = userFieldGroup;
			this.callback = callback;
			this. item = item;
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

	public static interface EntityFormOkCallback<E> extends Serializable{
		public void onSave(E item);
	}

	public VaadinEntityBuilder(Class<T> clazz){
		Entity entityAnnotation = clazz.getAnnotation(Entity.class);
		if(entityAnnotation == null)
			throw new IllegalArgumentException("clazz must has @Entity annotation.");
		this.theClass = clazz;
		this.data = new PropertyData(clazz);
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
	public FormLayout buildFormLayout(String caption, final EntityFormOkCallback<T> callback) {
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
			formLayout.addComponent(fieldGroup.buildAndBind(data.getDescriptionList().get(i), data.getPropertyNameList().get(i)));
		}
		
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
}
