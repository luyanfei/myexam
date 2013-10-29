package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.Attempt;
import cn.jhc.myexam.server.service.AttemptService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.Attempt")
@Component
public class AttemptLocator extends Locator<Attempt, Long> {

    @Autowired
    AttemptService attemptService;

    public Attempt create(Class<? extends cn.jhc.myexam.server.domain.Attempt> clazz) {
        return new Attempt();
    }

    public Attempt find(Class<? extends cn.jhc.myexam.server.domain.Attempt> clazz, Long id) {
        return attemptService.findAttempt(id);
    }

    public Class<Attempt> getDomainType() {
        return Attempt.class;
    }

    public Long getId(Attempt attempt) {
        return attempt.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Attempt attempt) {
        return attempt.getVersion();
    }
}
