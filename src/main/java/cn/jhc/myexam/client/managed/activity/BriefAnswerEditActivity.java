package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.BriefAnswerEditView;
import cn.jhc.myexam.client.managed.ui.BriefAnswerEditView.Delegate;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.request.BriefAnswerRequest;
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

public class BriefAnswerEditActivity extends AbstractProxyEditActivity<BriefAnswerProxy> implements Delegate {

    private final BriefAnswerEditView<?> view;

    private final BriefAnswerRequest request;

    public BriefAnswerEditActivity(EntityProxyId<BriefAnswerProxy> proxyId, ApplicationRequestFactory factory, BriefAnswerEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.briefAnswerRequest();
    }

    @Override
    protected BriefAnswerEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected BriefAnswerProxy createProxy() {
        return request.create(BriefAnswerProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(BriefAnswerProxy proxy) {
        request.saveBriefAnswer(proxy);
        return request;
    }
}
