package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.BriefAnswer;
import cn.jhc.myexam.server.service.BriefAnswerService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.BriefAnswer")
@Component
public class BriefAnswerLocator extends Locator<BriefAnswer, Long> {

    @Autowired
    BriefAnswerService briefAnswerService;

    public BriefAnswer create(Class<? extends cn.jhc.myexam.server.domain.BriefAnswer> clazz) {
        return new BriefAnswer();
    }

    public BriefAnswer find(Class<? extends cn.jhc.myexam.server.domain.BriefAnswer> clazz, Long id) {
        return briefAnswerService.findBriefAnswer(id);
    }

    public Class<BriefAnswer> getDomainType() {
        return BriefAnswer.class;
    }

    public Long getId(BriefAnswer briefAnswer) {
        return briefAnswer.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(BriefAnswer briefAnswer) {
        return briefAnswer.getVersion();
    }
}
