package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.managed.ui.editor.CategoryListEditor;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import java.util.List;

public class CategoryProxyRenderer extends ProxyRenderer<CategoryProxy> {

    private static CategoryProxyRenderer INSTANCE;

    protected CategoryProxyRenderer() {
        super(new String[] { "name" });
    }

    public static CategoryProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new CategoryProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(CategoryProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
