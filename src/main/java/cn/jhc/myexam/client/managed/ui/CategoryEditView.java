package cn.jhc.myexam.client.managed.ui;
import cn.jhc.myexam.client.managed.ui.editor.CategoryListEditor;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyEditView;
import java.util.Collection;
import java.util.List;

public interface CategoryEditView<V extends ProxyEditView<CategoryProxy, V>> extends ProxyEditView<CategoryProxy, V> {

    void setDelegate(Delegate delegate);

    interface Delegate extends cn.jhc.myexam.client.scaffold.place.ProxyEditView.Delegate {
    }
}
