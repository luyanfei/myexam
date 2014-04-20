package cn.jhc.myexam.shared.domain;

public enum CapabilityType {

	USER_MANAGEMENT("users"),QUESTION_MANAGEMENT("questions"),
	RESULT_MANAGEMENT("results"),EXAM_MANAGEMENT("exams"),
	PARTICIPATE_EXAM("participate");
	
	private String name;
	private CapabilityType(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
}
