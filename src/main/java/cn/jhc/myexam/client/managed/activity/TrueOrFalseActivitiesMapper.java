package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.TrueOrFalseDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.TrueOrFalseDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.TrueOrFalseDesktopListView;
import cn.jhc.myexam.client.managed.ui.mobile.TrueOrFalseMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.TrueOrFalseMobileEditView;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.TrueOrFalseProxy;
import cn.jhc.myexam.client.request.TrueOrFalseRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class TrueOrFalseActivitiesMapper extends TrueOrFalseActivitiesMapper_Roo_Gwt {

    public TrueOrFalseActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new TrueOrFalseDetailsActivity((EntityProxyId<TrueOrFalseProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? TrueOrFalseMobileDetailsView.instance() : TrueOrFalseDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
