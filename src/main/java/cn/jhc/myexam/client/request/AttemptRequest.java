package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.Attempt")
@ServiceName(value = "cn.jhc.myexam.server.service.AttemptService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface AttemptRequest extends AttemptRequest_Roo_Gwt {
}
