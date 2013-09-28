package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.managed.ui.editor.CategoryListEditor;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyDetailsView;
import java.util.List;

public interface CategoryDetailsView extends ProxyDetailsView<CategoryProxy> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyDetailsView.Delegate {
    }
}
