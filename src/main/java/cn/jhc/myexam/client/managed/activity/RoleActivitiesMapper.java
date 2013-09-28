package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.RoleDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.RoleDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.RoleDesktopListView;
import cn.jhc.myexam.client.managed.ui.mobile.RoleMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.RoleMobileEditView;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.request.RoleRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class RoleActivitiesMapper extends RoleActivitiesMapper_Roo_Gwt {

    public RoleActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new RoleDetailsActivity((EntityProxyId<RoleProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? RoleMobileDetailsView.instance() : RoleDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
