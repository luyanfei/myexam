// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "cn.jhc.myexam.server.domain.Role", locator = "cn.jhc.myexam.server.locator.RoleLocator")
@RooGwtProxy(value = "cn.jhc.myexam.server.domain.Role", readOnly = { "version", "id" }, scaffold = true)
public interface RoleProxy extends EntityProxy {

    abstract Long getId();

    abstract String getRolename();

    abstract void setRolename(String rolename);

    abstract UserProxy getUser();

    abstract void setUser(UserProxy user);

    abstract Integer getVersion();
}
