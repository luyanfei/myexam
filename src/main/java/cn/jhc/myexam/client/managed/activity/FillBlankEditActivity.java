package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.FillBlankEditView;
import cn.jhc.myexam.client.managed.ui.FillBlankEditView.Delegate;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.FillBlankProxy;
import cn.jhc.myexam.client.request.FillBlankRequest;
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

public class FillBlankEditActivity extends AbstractProxyEditActivity<FillBlankProxy> implements Delegate {

    private final FillBlankEditView<?> view;

    private final FillBlankRequest request;

    public FillBlankEditActivity(EntityProxyId<FillBlankProxy> proxyId, ApplicationRequestFactory factory, FillBlankEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.fillBlankRequest();
    }

    @Override
    protected FillBlankEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected FillBlankProxy createProxy() {
        return request.create(FillBlankProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(FillBlankProxy proxy) {
        request.saveFillBlank(proxy);
        return request;
    }
}
