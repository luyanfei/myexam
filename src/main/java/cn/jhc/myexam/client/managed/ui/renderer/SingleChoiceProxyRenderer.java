package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.SingleChoiceProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class SingleChoiceProxyRenderer extends ProxyRenderer<SingleChoiceProxy> {

    private static SingleChoiceProxyRenderer INSTANCE;

    protected SingleChoiceProxyRenderer() {
        super(new String[] { "question" });
    }

    public static SingleChoiceProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new SingleChoiceProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(SingleChoiceProxy object) {
        if (object == null) {
            return "";
        }
        return object.getQuestion() + " (" + object.getQuestion() + ")";
    }
}
