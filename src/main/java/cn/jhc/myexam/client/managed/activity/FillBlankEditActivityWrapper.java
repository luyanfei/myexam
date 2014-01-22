package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.FillBlankEditView;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.FillBlankProxy;
import cn.jhc.myexam.client.scaffold.activity.IsScaffoldMobileActivity;
import cn.jhc.myexam.client.scaffold.place.ProxyEditView;
import cn.jhc.myexam.client.scaffold.place.ProxyListPlace;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class FillBlankEditActivityWrapper extends FillBlankEditActivityWrapper_Roo_Gwt {

    private final EntityProxyId<FillBlankProxy> proxyId;

    public FillBlankEditActivityWrapper(ApplicationRequestFactory requests, View<?> view, Activity activity, EntityProxyId<FillBlankProxy> proxyId) {
        this.requests = requests;
        this.view = view;
        this.wrapped = activity;
        this.proxyId = proxyId;
    }

    public Place getBackButtonPlace() {
        return (proxyId == null) ? new ProxyListPlace(FillBlankProxy.class) : new ProxyPlace(proxyId, ProxyPlace.Operation.DETAILS);
    }

    public String getBackButtonText() {
        return "Cancel";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return (proxyId == null) ? "New FILL_BLANK" : "Edit FILL_BLANK";
    }

    public boolean hasEditButton() {
        return false;
    }

    @Override
    public String mayStop() {
        return wrapped.mayStop();
    }

    @Override
    public void onCancel() {
        wrapped.onCancel();
    }

    @Override
    public void onStop() {
        wrapped.onStop();
    }

    public interface View<V extends cn.jhc.myexam.client.managed.ui.FillBlankEditView<V>> extends View_Roo_Gwt<V> {
    }
}
