package cn.jhc.myexam.vaadin.component;

import cn.jhc.myexam.vaadin.util.Constants;

import com.vaadin.data.Property.ValueChangeEvent;
import com.vaadin.data.Property.ValueChangeListener;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.Table;
import com.vaadin.ui.VerticalLayout;

public class ConfirmImportRecordComponent extends CustomComponent{

	private static final long serialVersionUID = 1L;
	private VerticalLayout mainLayout;
	private CheckBox editableCheckBox;
	private Table table;
	private Button commitButton;

	public ConfirmImportRecordComponent(Table theTable) {
		this.table = theTable;
		
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setSizeUndefined();
		mainLayout.setSpacing(true);
		mainLayout.setMargin(true);
		setCompositionRoot(mainLayout);
		
		table.setStyleName("page-table");
		table.setCaption("将要添加的纪录");
		table.setImmediate(false);
		table.setWidth("700px");
		table.setHeight("-1px");
		table.setPageLength(Constants.TABLE_PAGE_SIZE);
		mainLayout.addComponent(table);

		buildOperationsLayout();
	}
	
	private void buildOperationsLayout() {
		HorizontalLayout horizontalLayout = new HorizontalLayout();
		horizontalLayout.setImmediate(false);
		horizontalLayout.setWidth("100%");
		
		commitButton = new Button("添加所有纪录");
		horizontalLayout.addComponent(commitButton);
		horizontalLayout.setComponentAlignment(commitButton, Alignment.MIDDLE_LEFT);
		
		editableCheckBox = new CheckBox("打开编辑模式", false);
		horizontalLayout.addComponent(editableCheckBox);
		horizontalLayout.setComponentAlignment(editableCheckBox, Alignment.MIDDLE_RIGHT);
		editableCheckBox.addValueChangeListener(new ValueChangeListener() {
			
			@Override
			public void valueChange(ValueChangeEvent event) {
				table.setEditable(editableCheckBox.getValue());
			}
		});
		
		mainLayout.addComponent(horizontalLayout);
	}

	/**
	 * commit button's ClickListener will be set outside ConfirmImportRecordComponent, so we 
	 * can reuse ConfirmImportRecordComponent in other case.
	 */
	public void addCommitButtonListener(Button.ClickListener listener) {
		commitButton.addClickListener(listener);
	}
	
	public Table getTable() {
		return this.table;
	}
	
	public void setTable(Table table) {
		this.table = table;
	}
}
