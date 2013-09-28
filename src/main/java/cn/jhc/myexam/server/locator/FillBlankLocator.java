package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.FillBlank;
import cn.jhc.myexam.server.service.FillBlankService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.FillBlank")
@Component
public class FillBlankLocator extends Locator<FillBlank, Long> {

    @Autowired
    FillBlankService fillBlankService;

    public FillBlank create(Class<? extends cn.jhc.myexam.server.domain.FillBlank> clazz) {
        return new FillBlank();
    }

    public FillBlank find(Class<? extends cn.jhc.myexam.server.domain.FillBlank> clazz, Long id) {
        return fillBlankService.findFillBlank(id);
    }

    public Class<FillBlank> getDomainType() {
        return FillBlank.class;
    }

    public Long getId(FillBlank fillBlank) {
        return fillBlank.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(FillBlank fillBlank) {
        return fillBlank.getVersion();
    }
}
