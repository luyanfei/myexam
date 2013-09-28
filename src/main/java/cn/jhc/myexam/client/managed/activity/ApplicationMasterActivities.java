package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationEntityTypesProcessor;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.managed.ui.desktop.BriefAnswerDesktopListView;
import cn.jhc.myexam.client.managed.ui.desktop.CategoryDesktopListView;
import cn.jhc.myexam.client.managed.ui.desktop.FillBlankDesktopListView;
import cn.jhc.myexam.client.managed.ui.desktop.GlossaryDesktopListView;
import cn.jhc.myexam.client.managed.ui.desktop.QuizDesktopListView;
import cn.jhc.myexam.client.managed.ui.desktop.RoleDesktopListView;
import cn.jhc.myexam.client.managed.ui.desktop.SingleChoiceDesktopListView;
import cn.jhc.myexam.client.managed.ui.desktop.TrueOrFalseDesktopListView;
import cn.jhc.myexam.client.managed.ui.desktop.UserDesktopListView;
import cn.jhc.myexam.client.managed.ui.mobile.BriefAnswerMobileListView;
import cn.jhc.myexam.client.managed.ui.mobile.CategoryMobileListView;
import cn.jhc.myexam.client.managed.ui.mobile.FillBlankMobileListView;
import cn.jhc.myexam.client.managed.ui.mobile.GlossaryMobileListView;
import cn.jhc.myexam.client.managed.ui.mobile.QuizMobileListView;
import cn.jhc.myexam.client.managed.ui.mobile.RoleMobileListView;
import cn.jhc.myexam.client.managed.ui.mobile.SingleChoiceMobileListView;
import cn.jhc.myexam.client.managed.ui.mobile.TrueOrFalseMobileListView;
import cn.jhc.myexam.client.managed.ui.mobile.UserMobileListView;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.FillBlankProxy;
import cn.jhc.myexam.client.proxy.GlossaryProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.SingleChoiceProxy;
import cn.jhc.myexam.client.proxy.TrueOrFalseProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.scaffold.ScaffoldApp;
import cn.jhc.myexam.client.scaffold.place.ProxyListPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public final class ApplicationMasterActivities extends ApplicationMasterActivities_Roo_Gwt {

    @Inject
    public ApplicationMasterActivities(ApplicationRequestFactory requests, PlaceController placeController) {
        this.requests = requests;
        this.placeController = placeController;
    }
}
