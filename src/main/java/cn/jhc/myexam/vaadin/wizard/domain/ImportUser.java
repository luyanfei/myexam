package cn.jhc.myexam.vaadin.wizard.domain;

import cn.jhc.myexam.annotation.Description;

/**
 * This javabean is used for import data from excel file.
 * @author luyanfei
 *
 */
public class ImportUser {
	@Description("用户名")
	private String username;
	@Description("用户名")
	private String displayName;
	public ImportUser() {
		
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getDisplayName() {
		return displayName;
	}
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	
}
