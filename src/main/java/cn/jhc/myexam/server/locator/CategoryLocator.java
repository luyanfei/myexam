package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.server.service.CategoryService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.Category")
@Component
public class CategoryLocator extends Locator<Category, Long> {

    @Autowired
    CategoryService categoryService;

    public Category create(Class<? extends cn.jhc.myexam.server.domain.Category> clazz) {
        return new Category();
    }

    public Category find(Class<? extends cn.jhc.myexam.server.domain.Category> clazz, Long id) {
        return categoryService.findCategory(id);
    }

    public Class<Category> getDomainType() {
        return Category.class;
    }

    public Long getId(Category category) {
        return category.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Category category) {
        return category.getVersion();
    }
}
