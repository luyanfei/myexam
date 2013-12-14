package cn.jhc.myexam.vaadin.component;

import cn.jhc.myexam.vaadin.util.Constants;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
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
		layout.setMargin(true);
		setContent(layout);
		
		table.setStyleName("page-table");
		table.setCaption("添加的考生列表");
		table.setImmediate(false);
		table.setWidth("100.0%");
		table.setHeight("-1px");
		table.setPageLength(Constants.TABLE_PAGE_SIZE);
		table.setEditable(true);
		layout.addComponent(table);
		
		Button commitButton = new Button("添加所有考生");
		layout.addComponent(commitButton);
		layout.setComponentAlignment(commitButton, Alignment.MIDDLE_LEFT);
		
		setClosable(true);
		setModal(true);
		setResizable(false);
	}
}
