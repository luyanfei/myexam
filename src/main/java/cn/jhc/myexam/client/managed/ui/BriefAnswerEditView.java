package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyEditView;
import java.util.Collection;
import java.util.List;

public interface BriefAnswerEditView<V extends ProxyEditView<BriefAnswerProxy, V>> extends ProxyEditView<BriefAnswerProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyEditView.Delegate {
    }
}
