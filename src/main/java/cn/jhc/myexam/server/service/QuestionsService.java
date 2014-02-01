package cn.jhc.myexam.server.service;

import java.util.List;

import cn.jhc.myexam.shared.domain.QuestionType;

public interface QuestionsService {
	public List<?> findAllQuestions(QuestionType type);
	public void saveQuestion(QuestionType type, Object question);
}
