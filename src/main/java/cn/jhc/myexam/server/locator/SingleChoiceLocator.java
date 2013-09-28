package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.SingleChoice;
import cn.jhc.myexam.server.service.SingleChoiceService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.SingleChoice")
@Component
public class SingleChoiceLocator extends Locator<SingleChoice, Long> {

    @Autowired
    SingleChoiceService singleChoiceService;

    public SingleChoice create(Class<? extends cn.jhc.myexam.server.domain.SingleChoice> clazz) {
        return new SingleChoice();
    }

    public SingleChoice find(Class<? extends cn.jhc.myexam.server.domain.SingleChoice> clazz, Long id) {
        return singleChoiceService.findSingleChoice(id);
    }

    public Class<SingleChoice> getDomainType() {
        return SingleChoice.class;
    }

    public Long getId(SingleChoice singleChoice) {
        return singleChoice.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(SingleChoice singleChoice) {
        return singleChoice.getVersion();
    }
}
