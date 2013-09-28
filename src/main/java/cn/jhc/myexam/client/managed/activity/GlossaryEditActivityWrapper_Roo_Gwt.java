// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.activity.GlossaryEditActivityWrapper.View;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.GlossaryEditView;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.GlossaryProxy;
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

public abstract class GlossaryEditActivityWrapper_Roo_Gwt implements Activity, IsScaffoldMobileActivity {

    protected Activity wrapped;

    protected View<?> view;

    protected ApplicationRequestFactory requests;

    @Override
    public void start(AcceptsOneWidget display, EventBus eventBus) {
        view.setCategoryPickerValues(Collections.<CategoryProxy>emptyList());
        requests.categoryRequest().findCategoryEntries(0, 50).with(cn.jhc.myexam.client.managed.ui.renderer.CategoryProxyRenderer.instance().getPaths()).fire(new Receiver<List<CategoryProxy>>() {

            public void onSuccess(List<CategoryProxy> response) {
                List<CategoryProxy> values = new ArrayList<CategoryProxy>();
                values.add(null);
                values.addAll(response);
                view.setCategoryPickerValues(values);
            }
        });
        wrapped.start(display, eventBus);
    }

    public interface View_Roo_Gwt<V extends cn.jhc.myexam.client.managed.ui.GlossaryEditView<V>> extends GlossaryEditView<V> {

        void setCategoryPickerValues(Collection<CategoryProxy> values);
    }
}
