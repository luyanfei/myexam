// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.TrueOrFalseProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.TrueOrFalse")
@ServiceName(value = "cn.jhc.myexam.server.service.TrueOrFalseService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface TrueOrFalseRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllTrueOrFalses();

    abstract Request<List<TrueOrFalseProxy>> findAllTrueOrFalses();

    abstract Request<List<TrueOrFalseProxy>> findTrueOrFalseEntries(int firstResult, int maxResults);

    abstract Request<TrueOrFalseProxy> findTrueOrFalse(Long id);

    abstract Request<Void> saveTrueOrFalse(TrueOrFalseProxy proxy);

    abstract Request<Void> deleteTrueOrFalse(TrueOrFalseProxy proxy);
}
