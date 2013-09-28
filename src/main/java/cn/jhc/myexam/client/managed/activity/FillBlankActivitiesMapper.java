package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.FillBlankDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.FillBlankDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.FillBlankDesktopListView;
import cn.jhc.myexam.client.managed.ui.mobile.FillBlankMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.FillBlankMobileEditView;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.FillBlankProxy;
import cn.jhc.myexam.client.request.FillBlankRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class FillBlankActivitiesMapper extends FillBlankActivitiesMapper_Roo_Gwt {

    public FillBlankActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new FillBlankDetailsActivity((EntityProxyId<FillBlankProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? FillBlankMobileDetailsView.instance() : FillBlankDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
