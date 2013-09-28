package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.TrueOrFalse;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = TrueOrFalse.class)
public interface TrueOrFalseRepository {
}
