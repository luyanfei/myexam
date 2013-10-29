package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.Attempt;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Attempt.class)
public interface AttemptRepository {
}
