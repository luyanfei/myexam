package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.TrueOrFalse;
import cn.jhc.myexam.server.service.TrueOrFalseService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.TrueOrFalse")
@Component
public class TrueOrFalseLocator extends Locator<TrueOrFalse, Long> {

    @Autowired
    TrueOrFalseService trueOrFalseService;

    public TrueOrFalse create(Class<? extends cn.jhc.myexam.server.domain.TrueOrFalse> clazz) {
        return new TrueOrFalse();
    }

    public TrueOrFalse find(Class<? extends cn.jhc.myexam.server.domain.TrueOrFalse> clazz, Long id) {
        return trueOrFalseService.findTrueOrFalse(id);
    }

    public Class<TrueOrFalse> getDomainType() {
        return TrueOrFalse.class;
    }

    public Long getId(TrueOrFalse trueOrFalse) {
        return trueOrFalse.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(TrueOrFalse trueOrFalse) {
        return trueOrFalse.getVersion();
    }
}
