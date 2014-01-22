package cn.jhc.myexam.vaadin.component;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Logger;

import cn.jhc.myexam.vaadin.util.NavigateItem;

import com.vaadin.navigator.Navigator;
import com.vaadin.ui.Alignment;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.CustomComponent;
import com.vaadin.ui.HorizontalLayout;
import com.vaadin.ui.NativeButton;
import com.vaadin.ui.UI;

public class TeacherNavigator extends CustomComponent {
	
	private static final Logger logger = Logger.getLogger(TeacherNavigator.class.getName());

	private HorizontalLayout horizontalLayout;

	private NativeButton mainButton;
	
	private NativeButton resultManageButton;

	private NativeButton examManageButton;

	private NativeButton questionsManageButton;

	private NativeButton userManageButton;
	
	/**
	 * The constructor should first build the MAIN layout, set the
	 * composition root and then do any custom initialization.
	 *
	 * The constructor will not be automatically regenerated by the
	 * visual editor.
	 */
	public TeacherNavigator() {
		horizontalLayout = buildHorizontalLayout();
		setWidth("100%");
		setCompositionRoot(horizontalLayout);
		addListenerForButtons();
		
	}

	private HorizontalLayout buildHorizontalLayout() {
		// common part: create layout
		horizontalLayout = new HorizontalLayout();
		horizontalLayout.setImmediate(false);
		horizontalLayout.setWidth("100.0%");
		horizontalLayout.setHeight("60px");
		horizontalLayout.setMargin(false);
		
		//mainButton
		mainButton = new NativeButton();
		mainButton.setStyleName("teacher-nav-button");
		mainButton.setCaption("首页");
		mainButton.setImmediate(true);
		mainButton.setDescription("查看系统信息、考试信息、题库信息、考生信息等。");
		mainButton.setWidth("100.0%");
		mainButton.setHeight("100.0%");
		horizontalLayout.addComponent(mainButton);
		horizontalLayout.setExpandRatio(mainButton, 1.0f);
		horizontalLayout.setComponentAlignment(mainButton, new Alignment(
				48));
		
		// userManageButton
		userManageButton = new NativeButton();
		userManageButton.setStyleName("teacher-nav-button");
		userManageButton.setCaption("考生管理");
		userManageButton.setImmediate(true);
		userManageButton.setDescription("可以在这里添加考生，删除考生。");
		userManageButton.setWidth("100.0%");
		userManageButton.setHeight("100.0%");
		horizontalLayout.addComponent(userManageButton);
		horizontalLayout.setExpandRatio(userManageButton, 1.0f);
		horizontalLayout.setComponentAlignment(userManageButton, new Alignment(
				48));
		
		// questionsManageButton
		questionsManageButton = new NativeButton();
		questionsManageButton.setStyleName("teacher-nav-button");
		questionsManageButton.setCaption("题库管理");
		questionsManageButton.setImmediate(true);
		questionsManageButton.setDescription("添加题目、编辑题目、删除题目、查找题目。");
		questionsManageButton.setWidth("100.0%");
		questionsManageButton.setHeight("100.0%");
		horizontalLayout.addComponent(questionsManageButton);
		horizontalLayout.setExpandRatio(questionsManageButton, 1.0f);
		horizontalLayout.setComponentAlignment(questionsManageButton,
				new Alignment(48));
		
		// examManageButton
		examManageButton = new NativeButton();
		examManageButton.setStyleName("teacher-nav-button");
		examManageButton.setCaption("考试管理");
		examManageButton.setImmediate(true);
		examManageButton.setDescription("添加考试，设置考试的起始时间等。");
		examManageButton.setWidth("100.0%");
		examManageButton.setHeight("100.0%");
		horizontalLayout.addComponent(examManageButton);
		horizontalLayout.setExpandRatio(examManageButton, 1.0f);
		horizontalLayout.setComponentAlignment(examManageButton, new Alignment(
				48));
		
		// resultManageButton
		resultManageButton = new NativeButton();
		resultManageButton.setStyleName("teacher-nav-button");
		resultManageButton.setCaption("结果管理");
		resultManageButton.setImmediate(true);
		resultManageButton.setDescription("查看考试结果，下载Excel成绩表等。");
		resultManageButton.setWidth("100.0%");
		resultManageButton.setHeight("100.0%");
		horizontalLayout.addComponent(resultManageButton);
		horizontalLayout.setExpandRatio(resultManageButton, 1.0f);
		horizontalLayout.setComponentAlignment(resultManageButton,
				new Alignment(48));
		
		return horizontalLayout;
	}
	
	private void addListenerForButtons() {
		// Button caption to NavigateItem map
		Map<String, NavigateItem> map = new HashMap<String, NavigateItem>();
		for (NavigateItem item : NavigateItem.values()) {
			map.put(item.getDescription(), item);
		}
		for (Iterator<com.vaadin.ui.Component> iterator = horizontalLayout.iterator() ; iterator.hasNext(); ) {
			com.vaadin.ui.Component component = iterator.next();
			if (! (component instanceof Button) )  continue;
			Button button = (Button) component;
				
			final NavigateItem item = map.get(button.getCaption());
			if (item == null)	continue;
			
			// set button's id to NavigateItem's name
			button.setId(item.toString());
			button.addClickListener(new Button.ClickListener() {

				@Override
				public void buttonClick(ClickEvent event) {
					Navigator navigator = UI.getCurrent().getNavigator();
					if (navigator == null) {
						logger.severe("getNavigator returns null, please check UI.");
						return;
					}
					navigator.navigateTo(item.toString());
				}
			});
		}
	}
}
