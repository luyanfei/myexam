package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.TrueOrFalse")
@ServiceName(value = "cn.jhc.myexam.server.service.TrueOrFalseService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface TrueOrFalseRequest extends TrueOrFalseRequest_Roo_Gwt {
}
