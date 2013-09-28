// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.FillBlankProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.FillBlank")
@ServiceName(value = "cn.jhc.myexam.server.service.FillBlankService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface FillBlankRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllFillBlanks();

    abstract Request<List<FillBlankProxy>> findAllFillBlanks();

    abstract Request<List<FillBlankProxy>> findFillBlankEntries(int firstResult, int maxResults);

    abstract Request<FillBlankProxy> findFillBlank(Long id);

    abstract Request<Void> saveFillBlank(FillBlankProxy proxy);

    abstract Request<Void> deleteFillBlank(FillBlankProxy proxy);
}
