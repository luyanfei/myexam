package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.BriefAnswerDetailsView;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.scaffold.activity.IsScaffoldMobileActivity;
import cn.jhc.myexam.client.scaffold.place.ProxyListPlace;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace.Operation;
import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.Set;

public class BriefAnswerDetailsActivity extends BriefAnswerDetailsActivity_Roo_Gwt {

    public BriefAnswerDetailsActivity(EntityProxyId<BriefAnswerProxy> proxyId, ApplicationRequestFactory requests, PlaceController placeController, BriefAnswerDetailsView view) {
        this.placeController = placeController;
        this.proxyId = proxyId;
        this.requests = requests;
        view.setDelegate(this);
        this.view = view;
    }

    public void editClicked() {
        placeController.goTo(getEditButtonPlace());
    }

    public Place getBackButtonPlace() {
        return new ProxyListPlace(BriefAnswerProxy.class);
    }

    public String getBackButtonText() {
        return "Back";
    }

    public Place getEditButtonPlace() {
        return new ProxyPlace(view.getValue().stableId(), Operation.EDIT);
    }

    public String getTitleText() {
        return "View BRIEF_ANSWER";
    }

    public boolean hasEditButton() {
        return true;
    }

    public void onCancel() {
        onStop();
    }

    public void onStop() {
        display = null;
    }

    public void start(AcceptsOneWidget displayIn, EventBus eventBus) {
        this.display = displayIn;
        Receiver<EntityProxy> callback = new Receiver<EntityProxy>() {

            public void onSuccess(EntityProxy proxy) {
                if (proxy == null) {
                    // Deleted entity, bad bookmark, that kind of thing
                    placeController.goTo(getBackButtonPlace());
                    return;
                }
                if (display == null) {
                    return;
                }
                view.setValue((BriefAnswerProxy) proxy);
                display.setWidget(view);
            }
        };
        find(callback);
    }
}
