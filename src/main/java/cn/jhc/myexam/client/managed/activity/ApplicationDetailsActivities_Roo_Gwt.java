// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.managed.activity;
import cn.jhc.myexam.client.managed.request.ApplicationEntityTypesProcessor;
import cn.jhc.myexam.client.managed.request.ApplicationRequestFactory;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.FillBlankProxy;
import cn.jhc.myexam.client.proxy.GlossaryProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.SingleChoiceProxy;
import cn.jhc.myexam.client.proxy.TrueOrFalseProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyPlace;
import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.inject.Inject;

public abstract class ApplicationDetailsActivities_Roo_Gwt implements ActivityMapper {

    protected ApplicationRequestFactory requests;

    protected PlaceController placeController;

    public Activity getActivity(Place place) {
        if (!(place instanceof ProxyPlace)) {
            return null;
        }
        final ProxyPlace proxyPlace = (ProxyPlace) place;
        return new ApplicationEntityTypesProcessor<Activity>() {

            @Override
            public void handleBriefAnswer(BriefAnswerProxy proxy) {
                setResult(new BriefAnswerActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }

            @Override
            public void handleCategory(CategoryProxy proxy) {
                setResult(new CategoryActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }

            @Override
            public void handleFillBlank(FillBlankProxy proxy) {
                setResult(new FillBlankActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }

            @Override
            public void handleGlossary(GlossaryProxy proxy) {
                setResult(new GlossaryActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }

            @Override
            public void handleQuiz(QuizProxy proxy) {
                setResult(new QuizActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }

            @Override
            public void handleRole(RoleProxy proxy) {
                setResult(new RoleActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }

            @Override
            public void handleSingleChoice(SingleChoiceProxy proxy) {
                setResult(new SingleChoiceActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }

            @Override
            public void handleTrueOrFalse(TrueOrFalseProxy proxy) {
                setResult(new TrueOrFalseActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }

            @Override
            public void handleUser(UserProxy proxy) {
                setResult(new UserActivitiesMapper(requests, placeController).getActivity(proxyPlace));
            }
        }.process(proxyPlace.getProxyClass());
    }
}
