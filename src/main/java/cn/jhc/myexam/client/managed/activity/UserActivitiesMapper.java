package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.UserDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.UserDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.UserDesktopListView;
import cn.jhc.myexam.client.managed.ui.editor.RoleListEditor;
import cn.jhc.myexam.client.managed.ui.mobile.UserMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.UserMobileEditView;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.request.UserRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.List;

public class UserActivitiesMapper extends UserActivitiesMapper_Roo_Gwt {

    public UserActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new UserDetailsActivity((EntityProxyId<UserProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? UserMobileDetailsView.instance() : UserDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
