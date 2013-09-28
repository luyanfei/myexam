package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.FillBlank")
@ServiceName(value = "cn.jhc.myexam.server.service.FillBlankService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface FillBlankRequest extends FillBlankRequest_Roo_Gwt {
}
