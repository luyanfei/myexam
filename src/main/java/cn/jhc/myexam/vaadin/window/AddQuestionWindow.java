package cn.jhc.myexam.vaadin.window;

import cn.jhc.myexam.shared.domain.QuestionType;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder.EntityFormOkCallback;

import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

public class AddQuestionWindow extends Window {

	private VerticalLayout mainLayout;
	private FormLayout formLayout;
	private QuestionType questionType;
	
	public AddQuestionWindow(QuestionType type) {
		super("添加新的题目");
		questionType = type;
		center();
		buildMainLayout();
		setContent(mainLayout);

		buildFormLayout();
		
		setClosable(true);
		setModal(true);
		setResizable(false);
	}
	
	private void buildFormLayout() {
		formLayout = VaadinEntityBuilder.create(questionType.getEntityClass())
				.buildFormLayout("添加新的题目", new EntityFormOkCallback() {

					@Override
					public void onSave(Object item) {
						
						AddQuestionWindow.this.close();
					}
				});
		
		mainLayout.addComponent(formLayout);
		mainLayout.setComponentAlignment(formLayout, Alignment.MIDDLE_CENTER);
	}

	private VerticalLayout buildMainLayout() {
		// common part: create layout
		mainLayout = new VerticalLayout();
		mainLayout.setImmediate(false);
		mainLayout.setMargin(true);
		return mainLayout;
	}
}
