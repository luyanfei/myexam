package cn.jhc.myexam.shared.domain;

import cn.jhc.myexam.server.domain.BriefAnswer;
import cn.jhc.myexam.server.domain.FillBlank;
import cn.jhc.myexam.server.domain.Glossary;
import cn.jhc.myexam.server.domain.SingleChoice;
import cn.jhc.myexam.server.domain.TrueOrFalse;

public enum QuestionType {

    SINGLE_CHOICE("单项选择题", SingleChoice.class), 
    GLOSSARY("名词解释", Glossary.class), 
    FILL_BLANK("填空题", FillBlank.class), 
    BRIEF_ANSWER("简答题", BriefAnswer.class), 
    TRUE_OR_FALSE("判断题", TrueOrFalse.class);
    
    private String description;
    private Class<?> entityClass;
    private QuestionType(String description, Class<?> clazz) {
    	this.description = description;
    	this.entityClass = clazz;
    }
    public String getDescription() {
    	return this.description;
    }
	public Class<?> getEntityClass() {
		return entityClass;
	}
}
