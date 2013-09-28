package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.managed.ui.editor.RoleListEditor;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyEditView;
import java.util.Collection;
import java.util.List;

public interface UserEditView<V extends ProxyEditView<UserProxy, V>> extends ProxyEditView<UserProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyEditView.Delegate {
    }
}
