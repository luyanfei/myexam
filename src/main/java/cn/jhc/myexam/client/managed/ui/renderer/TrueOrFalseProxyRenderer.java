package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.TrueOrFalseProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class TrueOrFalseProxyRenderer extends ProxyRenderer<TrueOrFalseProxy> {

    private static TrueOrFalseProxyRenderer INSTANCE;

    protected TrueOrFalseProxyRenderer() {
        super(new String[] { "question" });
    }

    public static TrueOrFalseProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new TrueOrFalseProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(TrueOrFalseProxy object) {
        if (object == null) {
            return "";
        }
        return object.getQuestion() + " (" + object.getQuestion() + ")";
    }
}
