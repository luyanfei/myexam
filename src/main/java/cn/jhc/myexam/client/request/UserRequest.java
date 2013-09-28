package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.User")
@ServiceName(value = "cn.jhc.myexam.server.service.UserService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface UserRequest extends UserRequest_Roo_Gwt {
}
