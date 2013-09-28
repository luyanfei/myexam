package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.Quiz")
@ServiceName(value = "cn.jhc.myexam.server.service.QuizService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface QuizRequest extends QuizRequest_Roo_Gwt {
}
