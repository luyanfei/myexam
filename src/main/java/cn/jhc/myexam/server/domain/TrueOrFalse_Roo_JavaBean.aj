// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.
// You may push code into the target .java compilation unit if you wish to edit any member(s).

package cn.jhc.myexam.server.domain;

import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.server.domain.TrueOrFalse;

privileged aspect TrueOrFalse_Roo_JavaBean {
    
    public String TrueOrFalse.getQuestion() {
        return this.question;
    }
    
    public void TrueOrFalse.setQuestion(String question) {
        this.question = question;
    }
    
    public Boolean TrueOrFalse.getAnswer() {
        return this.answer;
    }
    
    public void TrueOrFalse.setAnswer(Boolean answer) {
        this.answer = answer;
    }
    
    public Category TrueOrFalse.getCategory() {
        return this.category;
    }
    
    public void TrueOrFalse.setCategory(Category category) {
        this.category = category;
    }
    
}
