package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.proxy.AttemptProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyEditView;
import cn.jhc.myexam.shared.domain.QuestionType;
import java.util.Collection;
import java.util.List;

public interface AttemptEditView<V extends ProxyEditView<AttemptProxy, V>> extends ProxyEditView<AttemptProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyEditView.Delegate {
    }
}
