package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyDetailsView;

public interface RoleDetailsView extends ProxyDetailsView<RoleProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
