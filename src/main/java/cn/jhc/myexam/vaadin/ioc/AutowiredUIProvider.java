package cn.jhc.myexam.vaadin.ioc;

import com.vaadin.server.DefaultUIProvider;
import com.vaadin.server.UIClassSelectionEvent;
import com.vaadin.server.UICreateEvent;
import com.vaadin.server.UIProvider;
import com.vaadin.ui.UI;

@SuppressWarnings("serial")
public class AutowiredUIProvider extends UIProvider {

	private static final DefaultUIProvider DEFAULT_UI_PROVIDER = new DefaultUIProvider();
	
	@Override
	public Class<? extends UI> getUIClass(UIClassSelectionEvent event) {
		return DEFAULT_UI_PROVIDER.getUIClass(event);
	}
	
	@Override
	public UI createInstance(UICreateEvent event) {
		UI instance = super.createInstance(event);
		Injector.inject(instance);
		return instance;
	}

}
