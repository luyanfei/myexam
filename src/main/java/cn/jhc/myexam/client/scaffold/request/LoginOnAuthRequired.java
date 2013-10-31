package cn.jhc.myexam.client.scaffold.request;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.user.client.Window.Location;

import cn.jhc.myexam.client.scaffold.request.AuthRequiredEvent.Handler;

public class LoginOnAuthRequired implements Handler {
	
	public HandlerRegistration register(EventBus eventBus) {
		return AuthRequiredEvent.register(eventBus, this);
	}

	@Override
	public void onAuthFailure(AuthRequiredEvent event) {
		Location.replace(event.getLoginUrl());
	}

}
