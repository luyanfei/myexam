package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.BriefAnswerDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.BriefAnswerDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.BriefAnswerDesktopListView;
import cn.jhc.myexam.client.managed.ui.mobile.BriefAnswerMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.BriefAnswerMobileEditView;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.request.BriefAnswerRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class BriefAnswerActivitiesMapper extends BriefAnswerActivitiesMapper_Roo_Gwt {

    public BriefAnswerActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new BriefAnswerDetailsActivity((EntityProxyId<BriefAnswerProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? BriefAnswerMobileDetailsView.instance() : BriefAnswerDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
