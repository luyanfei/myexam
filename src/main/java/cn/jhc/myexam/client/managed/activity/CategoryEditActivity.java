package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.CategoryEditView;
import cn.jhc.myexam.client.managed.ui.CategoryEditView.Delegate;
import cn.jhc.myexam.client.managed.ui.editor.CategoryListEditor;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.request.CategoryRequest;
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

public class CategoryEditActivity extends AbstractProxyEditActivity<CategoryProxy> implements Delegate {

    private final CategoryEditView<?> view;

    private final CategoryRequest request;

    public CategoryEditActivity(EntityProxyId<CategoryProxy> proxyId, ApplicationRequestFactory factory, CategoryEditView<?> view, PlaceController placeController) {
        super(proxyId, factory, placeController);
        this.view = view;
        this.request = factory.categoryRequest();
    }

    @Override
    protected CategoryEditView<?> getView() {
        return view;
    }

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        this.view.setDelegate(this);
        super.start(display, eventBus);
    }

    @Override
    protected CategoryProxy createProxy() {
        return request.create(CategoryProxy.class);
    }

    @Override
    protected RequestContext createSaveRequest(CategoryProxy proxy) {
        request.saveCategory(proxy);
        return request;
    }
}
