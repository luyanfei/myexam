package cn.jhc.myexam.vaadin.util;

/**
 * This enum type is used for button id and view name. We keep the button id
 * as same as the view name.
 * 
 * @author luyanfei
 * 
 */
public enum NavigateItem {
	main("首页"), users("考生管理"), exams("考试管理"), questions("题库管理"), results("结果管理");
	
	private String description;

	private NavigateItem(String description) {
		this.description = description;
	}

	public String getDescription() {
		return this.description;
	}
}