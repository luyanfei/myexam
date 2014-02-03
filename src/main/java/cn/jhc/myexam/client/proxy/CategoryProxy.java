// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.List;
import java.util.Set;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "cn.jhc.myexam.server.domain.Category", locator = "cn.jhc.myexam.server.locator.CategoryLocator")
@RooGwtProxy(value = "cn.jhc.myexam.server.domain.Category", readOnly = { "version", "id" }, scaffold = true)
public interface CategoryProxy extends EntityProxy {

    abstract Long getId();

    abstract String getName();

    abstract void setName(String name);

    abstract String getInfo();

    abstract void setInfo(String info);

    abstract CategoryProxy getParent();

    abstract void setParent(CategoryProxy parent);

    abstract List<CategoryProxy> getChildren();

    abstract void setChildren(List<CategoryProxy> children);

    abstract Set<UserProxy> getUsers();

    abstract void setUsers(Set<UserProxy> users);

    abstract Integer getVersion();
}
