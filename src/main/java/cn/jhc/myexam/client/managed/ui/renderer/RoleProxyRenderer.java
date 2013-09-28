package cn.jhc.myexam.client.managed.ui.renderer;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import com.google.web.bindery.requestfactory.gwt.ui.client.ProxyRenderer;

public class RoleProxyRenderer extends ProxyRenderer<RoleProxy> {

    private static RoleProxyRenderer INSTANCE;

    protected RoleProxyRenderer() {
        super(new String[] { "rolename" });
    }

    public static RoleProxyRenderer instance() {
        if (INSTANCE == null) {
            INSTANCE = new RoleProxyRenderer();
        }
        return INSTANCE;
    }

    public String render(RoleProxy object) {
        if (object == null) {
            return "";
        }
        return object.getRolename() + " (" + object.getRolename() + ")";
    }
}
