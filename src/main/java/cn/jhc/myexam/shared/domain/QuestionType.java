package cn.jhc.myexam.shared.domain;

public enum QuestionType {

    SINGLE_CHOICE("单项选择题"), GLOSSARY("名词解释"), FILL_BLANK("填空题"), BRIEF_ANSWER("简答题"), TRUE_OR_FALSE("判断题");
    
    private String description;
    private QuestionType(String description) {
    	this.description = description;
    }
    public String getDescription() {
    	return this.description;
    }
}
