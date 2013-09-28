package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.BriefAnswer;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = BriefAnswer.class)
public interface BriefAnswerRepository {
}
