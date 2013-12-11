package cn.jhc.myexam.vaadin.view;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import com.vaadin.navigator.View;
import com.vaadin.navigator.ViewChangeListener.ViewChangeEvent;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.Upload;
import com.vaadin.ui.VerticalLayout;

@Component
@Scope("prototype")
public class ImportUsersView extends CustomComponent implements View {

	private static final long serialVersionUID = 1L;
	
	private Upload upload;
	
	public ImportUsersView() {
		VerticalLayout layout = new VerticalLayout();
		setCompositionRoot(layout);
		upload = new Upload();
		upload.setButtonCaption("上传Excel文件");
		layout.addComponent(upload);
		layout.setComponentAlignment(upload, Alignment.MIDDLE_CENTER);
	}

	@Override
	public void enter(ViewChangeEvent event) {
	}

}
