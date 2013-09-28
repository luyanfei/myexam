package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyDetailsView;

public interface QuizDetailsView extends ProxyDetailsView<QuizProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
