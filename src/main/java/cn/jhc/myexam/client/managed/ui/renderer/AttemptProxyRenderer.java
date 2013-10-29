package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.proxy.AttemptProxy;
import cn.jhc.myexam.client.proxy.QuizProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.shared.domain.QuestionType;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class AttemptProxyRenderer extends ProxyRenderer<AttemptProxy> {

    private static AttemptProxyRenderer INSTANCE;

    protected AttemptProxyRenderer() {
        super(new String[] { "answer" });
    }

    public static AttemptProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new AttemptProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(AttemptProxy object) {
        if (object == null) {
            return "";
        }
        return object.getAnswer() + " (" + object.getAnswer() + ")";
    }
}
