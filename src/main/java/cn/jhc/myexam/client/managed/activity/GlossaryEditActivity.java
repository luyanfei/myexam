package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.GlossaryEditView;
import cn.jhc.myexam.client.managed.ui.GlossaryEditView.Delegate;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.GlossaryProxy;
import cn.jhc.myexam.client.request.GlossaryRequest;
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

public class GlossaryEditActivity extends AbstractProxyEditActivity<GlossaryProxy> implements Delegate {

    private final GlossaryEditView<?> view;

    private final GlossaryRequest request;

    public GlossaryEditActivity(EntityProxyId<GlossaryProxy> proxyId, ApplicationRequestFactory factory, GlossaryEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.glossaryRequest();
    }

    @Override
    protected GlossaryEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected GlossaryProxy createProxy() {
        return request.create(GlossaryProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(GlossaryProxy proxy) {
        request.saveGlossary(proxy);
        return request;
    }
}
