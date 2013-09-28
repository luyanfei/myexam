package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.SingleChoice")
@ServiceName(value = "cn.jhc.myexam.server.service.SingleChoiceService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface SingleChoiceRequest extends SingleChoiceRequest_Roo_Gwt {
}
