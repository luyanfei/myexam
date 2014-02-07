package cn.jhc.myexam.vaadin.window;

import java.util.logging.Logger;

import cn.jhc.myexam.server.service.QuestionsService;
import cn.jhc.myexam.shared.domain.QuestionType;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder.EntityFormCallback;
import cn.jhc.myexam.vaadin.view.QuestionsManagerView;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Notification;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.Window;

@SuppressWarnings("serial")
public class AddQuestionWindow extends Window {
	
	private static final Logger logger = Logger.getLogger(AddQuestionWindow.class.getName());

	private VerticalLayout mainLayout;
	private FormLayout formLayout;
	private QuestionType questionType;
	
	private QuestionsService questionsService;
	private QuestionsManagerView questionsManagerView;
	
	public AddQuestionWindow(QuestionsManagerView view, QuestionType type, QuestionsService qService) {
		super("添加新的题目");
		questionType = type;
		questionsService = qService;
		questionsManagerView = view;
		
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
				.buildFormLayout("添加新的题目", new EntityFormCallback() {

					@Override
					public void onSave(Object item) {
						try {
							questionsService.saveQuestion(questionType, item);
						} catch (Throwable t) {
							logger.severe(t.getMessage());
							return;
						}
						questionsManagerView.getTableContainer().addItem(item);
						Notification.show("添加题目成功！");
						AddQuestionWindow.this.close();
					}

					@Override
					public void addCustomField(FormLayout formLayout,
							FieldGroup fieldGroup) {
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
