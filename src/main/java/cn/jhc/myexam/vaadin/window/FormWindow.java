package cn.jhc.myexam.vaadin.window;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public abstract class FormWindow extends Window {

	private static final long serialVersionUID = 1L;
	private VerticalLayout mainLayout;
	
	protected FormWindow() {
		center();
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setMargin(true);
		setContent(mainLayout);
//		setWidth("800px");
		
		FormLayout formLayout = buildFormLayout();
		mainLayout.addComponent(formLayout);
		mainLayout.setComponentAlignment(formLayout, Alignment.MIDDLE_CENTER);
		
		setClosable(true);
		setModal(true);
		setResizable(false);
	}

	protected abstract FormLayout buildFormLayout() ;

	
}
