package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.GlossaryProxy;
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

public class GlossaryListActivity extends GlossaryListActivity_Roo_Gwt {

    public GlossaryListActivity(ApplicationRequestFactory requests, ProxyListView<GlossaryProxy> view, PlaceController placeController) {
        super(placeController, view, GlossaryProxy.class);
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
        return "Glossarys";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<List<GlossaryProxy>> createRangeRequest(Range range) {
        return requests.glossaryRequest().findGlossaryEntries(range.getStart(), range.getLength());
    }
}
