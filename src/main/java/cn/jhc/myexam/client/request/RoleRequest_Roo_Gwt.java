// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.RoleProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.Role")
@ServiceName(value = "cn.jhc.myexam.server.service.RoleService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface RoleRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllRoles();

    abstract Request<List<RoleProxy>> findAllRoles();

    abstract Request<List<RoleProxy>> findRoleEntries(int firstResult, int maxResults);

    abstract Request<RoleProxy> findRole(Long id);

    abstract Request<Void> saveRole(RoleProxy proxy);

    abstract Request<Void> deleteRole(RoleProxy proxy);
}
