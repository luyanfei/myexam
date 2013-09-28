package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.GlossaryDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.GlossaryDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.GlossaryDesktopListView;
import cn.jhc.myexam.client.managed.ui.mobile.GlossaryMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.GlossaryMobileEditView;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.GlossaryProxy;
import cn.jhc.myexam.client.request.GlossaryRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class GlossaryActivitiesMapper extends GlossaryActivitiesMapper_Roo_Gwt {

    public GlossaryActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new GlossaryDetailsActivity((EntityProxyId<GlossaryProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? GlossaryMobileDetailsView.instance() : GlossaryDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
