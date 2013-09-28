package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.CategoryDesktopDetailsView;
import cn.jhc.myexam.client.managed.ui.desktop.CategoryDesktopEditView;
import cn.jhc.myexam.client.managed.ui.desktop.CategoryDesktopListView;
import cn.jhc.myexam.client.managed.ui.editor.CategoryListEditor;
import cn.jhc.myexam.client.managed.ui.mobile.CategoryMobileDetailsView;
import cn.jhc.myexam.client.managed.ui.mobile.CategoryMobileEditView;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.request.CategoryRequest;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.place.shared.PlaceController;
import com.google.web.bindery.requestfactory.shared.EntityProxyId;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import java.util.List;

public class CategoryActivitiesMapper extends CategoryActivitiesMapper_Roo_Gwt {

    public CategoryActivitiesMapper(ApplicationRequestFactory factory, PlaceController placeController) {
        this.factory = factory;
        this.placeController = placeController;
    }

    public Activity getActivity(ProxyPlace place) {
        switch(((place.getOperation()))) {
            case DETAILS:
                return new CategoryDetailsActivity((EntityProxyId<CategoryProxy>) place.getProxyId(), factory, placeController, ScaffoldApp.isMobile() ? CategoryMobileDetailsView.instance() : CategoryDesktopDetailsView.instance());
            case EDIT:
                return makeEditActivity(place);
            case CREATE:
                return makeCreateActivity();
        }
        throw new IllegalArgumentException("Unknown operation " + place.getOperation());
    }
}
