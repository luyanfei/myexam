package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.SingleChoiceProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyDetailsView;

public interface SingleChoiceDetailsView extends ProxyDetailsView<SingleChoiceProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
