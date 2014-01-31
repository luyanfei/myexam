package cn.jhc.myexam.vaadin.factory;

import static cn.jhc.myexam.shared.domain.QuestionType.*;
import cn.jhc.myexam.server.domain.BriefAnswer;
import cn.jhc.myexam.server.domain.FillBlank;
import cn.jhc.myexam.server.domain.Glossary;
import cn.jhc.myexam.server.domain.SingleChoice;
import cn.jhc.myexam.server.domain.TrueOrFalse;
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
	
	public static Class<?> getQuestionTypeClass(QuestionType type) {
		if(type == SINGLE_CHOICE)
			return SingleChoice.class;
		if(type == GLOSSARY)
			return Glossary.class;
		if(type == FILL_BLANK)
			return FillBlank.class;
		if(type == BRIEF_ANSWER)
			return BriefAnswer.class;
		if(type == TRUE_OR_FALSE)
			return TrueOrFalse.class;
		return null;
	}
}
