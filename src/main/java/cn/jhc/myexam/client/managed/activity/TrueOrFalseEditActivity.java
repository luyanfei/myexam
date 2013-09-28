package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.TrueOrFalseEditView;
import cn.jhc.myexam.client.managed.ui.TrueOrFalseEditView.Delegate;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.TrueOrFalseProxy;
import cn.jhc.myexam.client.request.TrueOrFalseRequest;
import cn.jhc.myexam.client.scaffold.place.AbstractProxyEditActivity;
import cn.jhc.myexam.client.scaffold.place.ProxyListPlace;
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

public class TrueOrFalseEditActivity extends AbstractProxyEditActivity<TrueOrFalseProxy> implements Delegate {

    private final TrueOrFalseEditView<?> view;

    private final TrueOrFalseRequest request;

    public TrueOrFalseEditActivity(EntityProxyId<TrueOrFalseProxy> proxyId, ApplicationRequestFactory factory, TrueOrFalseEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.trueOrFalseRequest();
    }

    @Override
    protected TrueOrFalseEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected TrueOrFalseProxy createProxy() {
        return request.create(TrueOrFalseProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(TrueOrFalseProxy proxy) {
        request.saveTrueOrFalse(proxy);
        return request;
    }
}
