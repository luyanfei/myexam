package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.FillBlankProxy;
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

public class FillBlankListActivity extends FillBlankListActivity_Roo_Gwt {

    public FillBlankListActivity(ApplicationRequestFactory requests, ProxyListView<FillBlankProxy> view, PlaceController placeController) {
        super(placeController, view, FillBlankProxy.class);
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
        return "FillBlanks";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<List<FillBlankProxy>> createRangeRequest(Range range) {
        return requests.fillBlankRequest().findFillBlankEntries(range.getStart(), range.getLength());
    }
}
