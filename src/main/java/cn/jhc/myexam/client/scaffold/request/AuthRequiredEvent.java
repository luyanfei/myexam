package cn.jhc.myexam.client.scaffold.request;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.EventHandler;
import com.google.gwt.event.shared.GwtEvent;
import com.google.gwt.event.shared.HandlerRegistration;

public class AuthRequiredEvent extends GwtEvent<AuthRequiredEvent.Handler> {
	private static final Type<Handler> TYPE = new Type<AuthRequiredEvent.Handler>();
	private String loginUrl;

	public interface Handler extends EventHandler {
		void onAuthFailure(AuthRequiredEvent event);
	}

	public AuthRequiredEvent(String loginUrl) {
		this.loginUrl = loginUrl;
	}

	@Override
	public com.google.gwt.event.shared.GwtEvent.Type<Handler> getAssociatedType() {
		return TYPE;
	}

	public static HandlerRegistration register(EventBus eventBus,
			AuthRequiredEvent.Handler handler) {
		return eventBus.addHandler(TYPE, handler);
	}

	@Override
	protected void dispatch(Handler handler) {
		handler.onAuthFailure(this);
	}

	public String getLoginUrl() {
		return loginUrl;
	}

}
