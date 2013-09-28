// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.request;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import com.google.web.bindery.requestfactory.shared.Request;
import com.google.web.bindery.requestfactory.shared.RequestContext;
import com.google.web.bindery.requestfactory.shared.ServiceName;
import java.util.List;
import org.springframework.roo.addon.gwt.RooGwtRequest;

@RooGwtRequest("cn.jhc.myexam.server.domain.Category")
@ServiceName(value = "cn.jhc.myexam.server.service.CategoryService", locator = "cn.jhc.myexam.server.locator.GwtServiceLocator")
public interface CategoryRequest_Roo_Gwt extends RequestContext {

    abstract Request<Long> countAllCategorys();

    abstract Request<List<CategoryProxy>> findAllCategorys();

    abstract Request<List<CategoryProxy>> findCategoryEntries(int firstResult, int maxResults);

    abstract Request<CategoryProxy> findCategory(Long id);

    abstract Request<Void> saveCategory(CategoryProxy proxy);

    abstract Request<Void> deleteCategory(CategoryProxy proxy);
}
