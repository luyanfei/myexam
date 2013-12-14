package cn.jhc.myexam.vaadin.util;

import com.vaadin.ui.UI;
import com.vaadin.ui.Window;

public class WindowUtils {

	private WindowUtils() {}
	
	public static Window findWindowById(String windowId) {
		Window importUsersWindow = null;
		for(Window window : UI.getCurrent().getWindows()) {
			if(window.getId().equals(windowId)) {
				importUsersWindow = window;
				break;
			}
		}
		return importUsersWindow;
	}

}
