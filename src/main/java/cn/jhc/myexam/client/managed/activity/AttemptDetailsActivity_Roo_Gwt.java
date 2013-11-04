// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.AttemptDetailsView;
import cn.jhc.myexam.client.managed.ui.AttemptDetailsView.Delegate;
import cn.jhc.myexam.client.proxy.AttemptProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.scaffold.activity.IsScaffoldMobileActivity;
import cn.jhc.myexam.client.scaffold.place.ProxyListPlace;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace.Operation;
import cn.jhc.myexam.shared.domain.QuestionType;
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

public abstract class AttemptDetailsActivity_Roo_Gwt extends AbstractActivity implements Delegate, IsScaffoldMobileActivity {

    protected ApplicationRequestFactory requests;

    protected EntityProxyId<AttemptProxy> proxyId;

    protected PlaceController placeController;

    protected AcceptsOneWidget display;

    protected AttemptDetailsView view;

    public void deleteClicked() {
        if (!view.confirm("Really delete this entry? You cannot undo this change.")) {
            return;
        }
        requests.attemptRequest().deleteAttempt(view.getValue()).fire(new Receiver<Void>() {

            public void onSuccess(Void ignore) {
                if (display == null) {
                    // This activity is dead
                    return;
                }
                // Go back to the previous place.
                placeController.goTo(getBackButtonPlace());
            }
        });
    }

    protected void find(Receiver<EntityProxy> callback) {
        requests.find(proxyId).with("user", "quiz").fire(callback);
    }
}