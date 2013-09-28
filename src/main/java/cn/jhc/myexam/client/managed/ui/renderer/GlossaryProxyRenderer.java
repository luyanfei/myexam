package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.GlossaryProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class GlossaryProxyRenderer extends ProxyRenderer<GlossaryProxy> {

    private static GlossaryProxyRenderer INSTANCE;

    protected GlossaryProxyRenderer() {
        super(new String[] { "term" });
    }

    public static GlossaryProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new GlossaryProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(GlossaryProxy object) {
        if (object == null) {
            return "";
        }
        return object.getTerm() + " (" + object.getTerm() + ")";
    }
}
