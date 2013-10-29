package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.proxy.AttemptProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyDetailsView;
import cn.jhc.myexam.shared.domain.QuestionType;

public interface AttemptDetailsView extends ProxyDetailsView<AttemptProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
