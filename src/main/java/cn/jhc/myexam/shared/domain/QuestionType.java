package cn.jhc.myexam.shared.domain;

public enum QuestionType {

    SingleChoice("单项选择题"), Glossary("名词解释"), FillBlank("填空题"), BriefAnswer("简答题"), TrueOrFlase("判断题");
    
    private String description;
    private QuestionType(String description) {
    	this.description = description;
    }
    public String getDescription() {
    	return this.description;
    }
}
