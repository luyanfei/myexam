package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.Quiz;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Quiz.class)
public interface QuizRepository {
}
