package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.FillBlankProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class FillBlankProxyRenderer extends ProxyRenderer<FillBlankProxy> {

    private static FillBlankProxyRenderer INSTANCE;

    protected FillBlankProxyRenderer() {
        super(new String[] { "question" });
    }

    public static FillBlankProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new FillBlankProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(FillBlankProxy object) {
        if (object == null) {
            return "";
        }
        return object.getQuestion() + " (" + object.getQuestion() + ")";
    }
}
