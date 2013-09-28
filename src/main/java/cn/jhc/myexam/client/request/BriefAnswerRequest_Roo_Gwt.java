// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.BriefAnswer")
@ServiceName(value = "cn.jhc.myexam.server.service.BriefAnswerService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface BriefAnswerRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllBriefAnswers();

    abstract Request<List<BriefAnswerProxy>> findAllBriefAnswers();

    abstract Request<List<BriefAnswerProxy>> findBriefAnswerEntries(int firstResult, int maxResults);

    abstract Request<BriefAnswerProxy> findBriefAnswer(Long id);

    abstract Request<Void> saveBriefAnswer(BriefAnswerProxy proxy);

    abstract Request<Void> deleteBriefAnswer(BriefAnswerProxy proxy);
}
