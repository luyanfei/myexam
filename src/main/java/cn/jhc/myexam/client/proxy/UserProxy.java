// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "cn.jhc.myexam.server.domain.User", locator = "cn.jhc.myexam.server.locator.UserLocator")
@RooGwtProxy(value = "cn.jhc.myexam.server.domain.User", readOnly = { "version", "id" }, scaffold = true)
public interface UserProxy extends EntityProxy {

    abstract Long getId();

    abstract String getUsername();

    abstract void setUsername(String username);

    abstract String getPassword();

    abstract void setPassword(String password);

    abstract Boolean getEnabled();

    abstract void setEnabled(Boolean enabled);

    abstract String getDisplayName();

    abstract void setDisplayName(String displayName);

    abstract List<RoleProxy> getRoles();

    abstract void setRoles(List<RoleProxy> roles);

    abstract Integer getVersion();
}
