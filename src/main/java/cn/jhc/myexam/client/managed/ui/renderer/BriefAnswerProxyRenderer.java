package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class BriefAnswerProxyRenderer extends ProxyRenderer<BriefAnswerProxy> {

    private static BriefAnswerProxyRenderer INSTANCE;

    protected BriefAnswerProxyRenderer() {
        super(new String[] { "question" });
    }

    public static BriefAnswerProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new BriefAnswerProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(BriefAnswerProxy object) {
        if (object == null) {
            return "";
        }
        return object.getQuestion() + " (" + object.getQuestion() + ")";
    }
}
