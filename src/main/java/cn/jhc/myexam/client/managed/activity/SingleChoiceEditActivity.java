package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.SingleChoiceEditView;
import cn.jhc.myexam.client.managed.ui.SingleChoiceEditView.Delegate;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.SingleChoiceProxy;
import cn.jhc.myexam.client.request.SingleChoiceRequest;
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

public class SingleChoiceEditActivity extends AbstractProxyEditActivity<SingleChoiceProxy> implements Delegate {

    private final SingleChoiceEditView<?> view;

    private final SingleChoiceRequest request;

    public SingleChoiceEditActivity(EntityProxyId<SingleChoiceProxy> proxyId, ApplicationRequestFactory factory, SingleChoiceEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.singleChoiceRequest();
    }

    @Override
    protected SingleChoiceEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected SingleChoiceProxy createProxy() {
        return request.create(SingleChoiceProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(SingleChoiceProxy proxy) {
        request.saveSingleChoice(proxy);
        return request;
    }
}
