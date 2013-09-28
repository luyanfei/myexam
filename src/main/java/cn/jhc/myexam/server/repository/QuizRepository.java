package cn.jhc.myexam.server.repository;
import java.util.Date;
import java.util.List;

import cn.jhc.myexam.server.domain.Quiz;

import org.springframework.data.jpa.repository.Query;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Quiz.class)
public interface QuizRepository {
	
	@Query("select q from Quiz q where ?1 between q.timeOpen and q.timeClose")
	public List<Quiz> findRunningQuizes(Date current);
}
