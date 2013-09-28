package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class QuizProxyRenderer extends ProxyRenderer<QuizProxy> {

    private static QuizProxyRenderer INSTANCE;

    protected QuizProxyRenderer() {
        super(new String[] { "name" });
    }

    public static QuizProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new QuizProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(QuizProxy object) {
        if (object == null) {
            return "";
        }
        return object.getName() + " (" + object.getName() + ")";
    }
}
