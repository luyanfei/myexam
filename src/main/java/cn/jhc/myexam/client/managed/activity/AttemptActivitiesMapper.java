package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.AttemptDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.AttemptDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.AttemptDesktopListView;
import cn.jhc.myexam.client.managed.ui.mobile.AttemptMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.AttemptMobileEditView;
import cn.jhc.myexam.client.proxy.AttemptProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.request.AttemptRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import cn.jhc.myexam.shared.domain.QuestionType;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;

public class AttemptActivitiesMapper extends AttemptActivitiesMapper_Roo_Gwt {

    public AttemptActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new AttemptDetailsActivity((EntityProxyId<AttemptProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? AttemptMobileDetailsView.instance() : AttemptDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
