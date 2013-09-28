package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.SingleChoice;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = SingleChoice.class)
public interface SingleChoiceRepository {
}
