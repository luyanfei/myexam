package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.Category")
@ServiceName(value = "cn.jhc.myexam.server.service.CategoryService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface CategoryRequest extends CategoryRequest_Roo_Gwt {
}
