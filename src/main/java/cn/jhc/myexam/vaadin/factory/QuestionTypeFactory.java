package cn.jhc.myexam.vaadin.factory;

import cn.jhc.myexam.shared.domain.QuestionType;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanItemContainer;

public class QuestionTypeFactory {

	private static Container container = null;
	
	private QuestionTypeFactory() {}
	
	public static Container getQuestionTypeContainer() {
		if(container == null) {
			BeanItemContainer<QuestionType> beanContainer = new BeanItemContainer<QuestionType>(QuestionType.class);
			for(QuestionType qType : QuestionType.values()) {
				beanContainer.addItem(qType);
			}
			container = beanContainer;
		}
		return container;
	}
}
