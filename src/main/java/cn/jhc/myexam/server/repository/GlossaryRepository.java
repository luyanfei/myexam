package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.Glossary;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Glossary.class)
public interface GlossaryRepository {
}
