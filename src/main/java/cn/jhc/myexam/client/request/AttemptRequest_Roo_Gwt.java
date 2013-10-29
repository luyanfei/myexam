// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.AttemptProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.Attempt")
@ServiceName(value = "cn.jhc.myexam.server.service.AttemptService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface AttemptRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllAttempts();

    abstract Request<List<AttemptProxy>> findAllAttempts();

    abstract Request<List<AttemptProxy>> findAttemptEntries(int firstResult, int maxResults);

    abstract Request<AttemptProxy> findAttempt(Long id);

    abstract Request<Void> saveAttempt(AttemptProxy proxy);

    abstract Request<Void> deleteAttempt(AttemptProxy proxy);
}
