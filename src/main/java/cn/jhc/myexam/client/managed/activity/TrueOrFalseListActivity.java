package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.TrueOrFalseProxy;
import cn.jhc.myexam.client.scaffold.ScaffoldMobileApp;
import cn.jhc.myexam.client.scaffold.activity.IsScaffoldMobileActivity;
import cn.jhc.myexam.client.scaffold.place.AbstractProxyListActivity;
import cn.jhc.myexam.client.scaffold.place.ProxyListView;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.view.client.Range;
import com.google.web.bindery.requestfactory.shared.Receiver;
import com.google.web.bindery.requestfactory.shared.Request;
import java.util.List;

public class TrueOrFalseListActivity extends TrueOrFalseListActivity_Roo_Gwt {

    public TrueOrFalseListActivity(ApplicationRequestFactory requests, ProxyListView<TrueOrFalseProxy> view, PlaceController placeController) {
        super(placeController, view, TrueOrFalseProxy.class);
        this.requests = requests;
    }

    public Place getBackButtonPlace() {
        return ScaffoldMobileApp.ROOT_PLACE;
    }

    public String getBackButtonText() {
        return "Entities";
    }

    public Place getEditButtonPlace() {
        return null;
    }

    public String getTitleText() {
        return "TrueOrFalses";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<List<TrueOrFalseProxy>> createRangeRequest(Range range) {
        return requests.trueOrFalseRequest().findTrueOrFalseEntries(range.getStart(), range.getLength());
    }
}
