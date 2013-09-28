package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.GlossaryProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyEditView;
import java.util.Collection;
import java.util.List;

public interface GlossaryEditView<V extends ProxyEditView<GlossaryProxy, V>> extends ProxyEditView<GlossaryProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyEditView.Delegate {
    }
}
