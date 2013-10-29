package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.AttemptEditView;
import cn.jhc.myexam.client.managed.ui.AttemptEditView.Delegate;
import cn.jhc.myexam.client.proxy.AttemptProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.request.AttemptRequest;
import cn.jhc.myexam.client.scaffold.place.AbstractProxyEditActivity;
import cn.jhc.myexam.client.scaffold.place.ProxyListPlace;
import cn.jhc.myexam.shared.domain.QuestionType;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class AttemptEditActivity extends AbstractProxyEditActivity<AttemptProxy> implements Delegate {

    private final AttemptEditView<?> view;

    private final AttemptRequest request;

    public AttemptEditActivity(EntityProxyId<AttemptProxy> proxyId, ApplicationRequestFactory factory, AttemptEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.attemptRequest();
    }

    @Override
    protected AttemptEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected AttemptProxy createProxy() {
        return request.create(AttemptProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(AttemptProxy proxy) {
        request.saveAttempt(proxy);
        return request;
    }
}
