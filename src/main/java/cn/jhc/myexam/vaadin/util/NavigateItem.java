package cn.jhc.myexam.vaadin.util;

/**
 * This enum type is used for button id and view name. We keep the button id
 * as same as the view name.
 * 
 * @author luyanfei
 * 
 */
public enum NavigateItem {
	MAIN("首页"), USERS("考生管理"), EXAMS("考试管理"), QUESTIONS("题库管理"), RESULTS("结果管理");
	
	private String description;

	private NavigateItem(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}