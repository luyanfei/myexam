package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.SingleChoiceDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.SingleChoiceDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.SingleChoiceDesktopListView;
import cn.jhc.myexam.client.managed.ui.mobile.SingleChoiceMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.SingleChoiceMobileEditView;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.SingleChoiceProxy;
import cn.jhc.myexam.client.request.SingleChoiceRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class SingleChoiceActivitiesMapper extends SingleChoiceActivitiesMapper_Roo_Gwt {

    public SingleChoiceActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new SingleChoiceDetailsActivity((EntityProxyId<SingleChoiceProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? SingleChoiceMobileDetailsView.instance() : SingleChoiceDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
