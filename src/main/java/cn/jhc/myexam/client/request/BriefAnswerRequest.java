package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.BriefAnswer")
@ServiceName(value = "cn.jhc.myexam.server.service.BriefAnswerService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface BriefAnswerRequest extends BriefAnswerRequest_Roo_Gwt {
}
