// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.SingleChoiceProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.SingleChoice")
@ServiceName(value = "cn.jhc.myexam.server.service.SingleChoiceService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface SingleChoiceRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllSingleChoices();

    abstract Request<List<SingleChoiceProxy>> findAllSingleChoices();

    abstract Request<List<SingleChoiceProxy>> findSingleChoiceEntries(int firstResult, int maxResults);

    abstract Request<SingleChoiceProxy> findSingleChoice(Long id);

    abstract Request<Void> saveSingleChoice(SingleChoiceProxy proxy);

    abstract Request<Void> deleteSingleChoice(SingleChoiceProxy proxy);
}
