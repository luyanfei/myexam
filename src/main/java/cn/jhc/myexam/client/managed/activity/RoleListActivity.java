package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
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

public class RoleListActivity extends RoleListActivity_Roo_Gwt {

    public RoleListActivity(ApplicationRequestFactory requests, ProxyListView<RoleProxy> view, PlaceController placeController) {
        super(placeController, view, RoleProxy.class);
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
        return "Roles";
    }

    public boolean hasEditButton() {
        return false;
    }

    protected Request<List<RoleProxy>> createRangeRequest(Range range) {
        return requests.roleRequest().findRoleEntries(range.getStart(), range.getLength());
    }
}
