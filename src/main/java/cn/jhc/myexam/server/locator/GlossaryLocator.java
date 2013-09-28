package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.Glossary;
import cn.jhc.myexam.server.service.GlossaryService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.Glossary")
@Component
public class GlossaryLocator extends Locator<Glossary, Long> {

    @Autowired
    GlossaryService glossaryService;

    public Glossary create(Class<? extends cn.jhc.myexam.server.domain.Glossary> clazz) {
        return new Glossary();
    }

    public Glossary find(Class<? extends cn.jhc.myexam.server.domain.Glossary> clazz, Long id) {
        return glossaryService.findGlossary(id);
    }

    public Class<Glossary> getDomainType() {
        return Glossary.class;
    }

    public Long getId(Glossary glossary) {
        return glossary.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Glossary glossary) {
        return glossary.getVersion();
    }
}
