package cn.jhc.myexam.vaadin.util;

import com.vaadin.data.util.BeanContainer;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Table;
import com.vaadin.ui.themes.BaseTheme;

public class TableUtils {

	public static interface DeleteCallback<T> {
		public void onDelete(T delItem);
	}

	public static <T> Table addDeleteColumn(Table table,
			final DeleteCallback<T> callback) {
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
