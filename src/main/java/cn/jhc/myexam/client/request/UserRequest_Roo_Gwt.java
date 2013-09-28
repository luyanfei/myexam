// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.UserProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.User")
@ServiceName(value = "cn.jhc.myexam.server.service.UserService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface UserRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllUsers();

    abstract Request<List<UserProxy>> findAllUsers();

    abstract Request<List<UserProxy>> findUserEntries(int firstResult, int maxResults);

    abstract Request<UserProxy> findUser(Long id);

    abstract Request<Void> saveUser(UserProxy proxy);

    abstract Request<Void> deleteUser(UserProxy proxy);
}
