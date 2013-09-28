package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.QuizDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.QuizDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.QuizDesktopListView;
import cn.jhc.myexam.client.managed.ui.mobile.QuizMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.QuizMobileEditView;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.request.QuizRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class QuizActivitiesMapper extends QuizActivitiesMapper_Roo_Gwt {

    public QuizActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new QuizDetailsActivity((EntityProxyId<QuizProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? QuizMobileDetailsView.instance() : QuizDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
