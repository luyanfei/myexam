package cn.jhc.myexam.client.scaffold.request;

import com.google.gwt.event.shared.EventBus;
import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.Response;
import com.google.web.bindery.requestfactory.gwt.client.DefaultRequestTransport;
import com.google.web.bindery.requestfactory.shared.ServerFailure;

public class AuthRequestTransport extends DefaultRequestTransport {

	private final class AuthCallbackWrapper implements RequestCallback {
		private final RequestCallback delegate;
		private final TransportReceiver receiver;

		public AuthCallbackWrapper(RequestCallback delegate,
				TransportReceiver receiver) {
			this.delegate = delegate;
			this.receiver = receiver;
		}

		@Override
		public void onResponseReceived(Request request, Response response) {
			if(Response.SC_UNAUTHORIZED == response.getStatusCode()) {
				String loginUrl = response.getHeader("login");
				if(loginUrl != null) {
					boolean fatal = false;
					ServerFailure failure = new ServerFailure("Unauthenticated user", null, null, fatal);
					receiver.onTransportFailure(failure);
					eventBus.fireEvent(new AuthRequiredEvent(loginUrl));
					return;
				}
			}
			delegate.onResponseReceived(request, response);
		}

		@Override
		public void onError(Request request, Throwable exception) {
			delegate.onError(request, exception);
		}

	}

	private final EventBus eventBus;
	
	public AuthRequestTransport(EventBus eventBus) {
		this.eventBus = eventBus;
	}
	
	@Override
	protected RequestCallback createRequestCallback(final TransportReceiver receiver) {
		final RequestCallback superRequestCallback = super.createRequestCallback(receiver);
		return new AuthCallbackWrapper(superRequestCallback, receiver);
	}
}
