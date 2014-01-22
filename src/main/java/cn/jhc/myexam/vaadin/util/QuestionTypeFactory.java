package cn.jhc.myexam.vaadin.util;

import cn.jhc.myexam.shared.domain.QuestionType;

import com.vaadin.data.Container;
import com.vaadin.data.util.BeanContainer;

public class QuestionTypeFactory {

	private static Container container = null;
	
	private QuestionTypeFactory() {}
	
	public static Container getQuestionTypeContainer() {
		if(container == null) {
			BeanContainer<String, QuestionType> beanContainer= new BeanContainer<String, QuestionType>(QuestionType.class);
			for(QuestionType qType : QuestionType.values()) {
				beanContainer.addItem(qType.getDescription(), qType);
			}
			container = beanContainer;
		}
		return container;
	}
}
