package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.Role")
@ServiceName(value = "cn.jhc.myexam.server.service.RoleService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface RoleRequest extends RoleRequest_Roo_Gwt {
}
