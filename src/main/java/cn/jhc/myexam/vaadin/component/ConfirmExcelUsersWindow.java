package cn.jhc.myexam.vaadin.component;

import cn.jhc.myexam.vaadin.util.Constants;

import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class ConfirmExcelUsersWindow extends Window {

	public ConfirmExcelUsersWindow(Table table) {
		super("确认导入的考生数据");
		center();
		VerticalLayout layout = new VerticalLayout();
		layout.setImmediate(false);
		layout.setSizeUndefined();
		layout.setSpacing(true);
		setContent(layout);
		
		table.setStyleName("page-table");
		table.setCaption("考生列表");
		table.setImmediate(false);
		table.setWidth("100.0%");
		table.setHeight("-1px");
		table.setPageLength(Constants.TABLE_PAGE_SIZE);
		layout.addComponent(table);
		
		setClosable(true);
		setModal(true);
		setResizable(false);
	}
}
