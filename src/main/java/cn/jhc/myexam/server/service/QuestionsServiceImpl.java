package cn.jhc.myexam.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jhc.myexam.processor.RepositoryEntityTypesProcessor;
import cn.jhc.myexam.shared.domain.QuestionType;

@Service @Transactional
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	private RepositoryEntityTypesProcessor repositoryEntityTypesProcessor;
	
	public List<?> findAllQuestions(QuestionType type) {
		Class<?> clazz = type.getEntityClass();
		JpaRepository<?, ?> repository = repositoryEntityTypesProcessor.process(clazz);
		return repository == null ? null : repository.findAll();
	}

	@Override
	public void saveQuestion(QuestionType type, Object question) {
		Class<?> clazz = type.getEntityClass();
		JpaRepository repository = repositoryEntityTypesProcessor.process(clazz);
		repository.saveAndFlush(question);
	}
}
