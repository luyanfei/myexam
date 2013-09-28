package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.UserEditView;
import cn.jhc.myexam.client.managed.ui.UserEditView.Delegate;
import cn.jhc.myexam.client.managed.ui.editor.RoleListEditor;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.request.UserRequest;
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

public class UserEditActivity extends AbstractProxyEditActivity<UserProxy> implements Delegate {

    private final UserEditView<?> view;

    private final UserRequest request;

    public UserEditActivity(EntityProxyId<UserProxy> proxyId, ApplicationRequestFactory factory, UserEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.userRequest();
    }

    @Override
    protected UserEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected UserProxy createProxy() {
        return request.create(UserProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(UserProxy proxy) {
        request.saveUser(proxy);
        return request;
    }
}
