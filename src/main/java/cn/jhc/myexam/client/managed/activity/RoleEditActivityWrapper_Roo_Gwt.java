// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.activity.RoleEditActivityWrapper.View;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.RoleEditView;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
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

public abstract class RoleEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        view.setUserPickerValues(Collections.<UserProxy>emptyList());
        requests.userRequest().findUserEntries(0, 50).with(cn.jhc.myexam.client.managed.ui.renderer.UserProxyRenderer.instance().getPaths()).fire(new Receiver<List<UserProxy>>() {

            public void onSuccess(List<UserProxy> response) {
                List<UserProxy> values = new ArrayList<UserProxy>();
                values.add(null);
                values.addAll(response);
                view.setUserPickerValues(values);
            }
        });
        wrapped.start(display, eventBus);
    }

    public interface View_Roo_Gwt<V extends cn.jhc.myexam.client.managed.ui.RoleEditView<V>> extends RoleEditView<V> {

        void setUserPickerValues(Collection<UserProxy> values);
    }
}
