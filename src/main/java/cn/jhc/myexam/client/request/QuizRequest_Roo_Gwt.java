// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.QuizProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.Quiz")
@ServiceName(value = "cn.jhc.myexam.server.service.QuizService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface QuizRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllQuizes();

    abstract Request<List<QuizProxy>> findAllQuizes();

    abstract Request<List<QuizProxy>> findQuizEntries(int firstResult, int maxResults);

    abstract Request<QuizProxy> findQuiz(Long id);

    abstract Request<Void> saveQuiz(QuizProxy proxy);

    abstract Request<Void> deleteQuiz(QuizProxy proxy);
}
