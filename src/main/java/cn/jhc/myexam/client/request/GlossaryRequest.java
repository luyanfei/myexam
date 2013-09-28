package cn.jhc.myexam.client.request;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import org.springframework.roo.addon.gwt.RooGwtUnmanagedRequest;

@RooGwtUnmanagedRequest("cn.jhc.myexam.server.domain.Glossary")
@ServiceName(value = "cn.jhc.myexam.server.service.GlossaryService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface GlossaryRequest extends GlossaryRequest_Roo_Gwt {
}
