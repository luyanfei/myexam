// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.GlossaryProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.Glossary")
@ServiceName(value = "cn.jhc.myexam.server.service.GlossaryService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface GlossaryRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllGlossarys();

    abstract Request<List<GlossaryProxy>> findAllGlossarys();

    abstract Request<List<GlossaryProxy>> findGlossaryEntries(int firstResult, int maxResults);

    abstract Request<GlossaryProxy> findGlossary(Long id);

    abstract Request<Void> saveGlossary(GlossaryProxy proxy);

    abstract Request<Void> deleteGlossary(GlossaryProxy proxy);
}
