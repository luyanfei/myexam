package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.managed.ui.editor.RoleListEditor;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;
import java.util.List;

public class UserProxyRenderer extends ProxyRenderer<UserProxy> {

    private static UserProxyRenderer INSTANCE;

    protected UserProxyRenderer() {
        super(new String[] { "username" });
    }

    public static UserProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new UserProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(UserProxy object) {
        if (object == null) {
            return "";
        }
        return object.getUsername() + " (" + object.getUsername() + ")";
    }
}
