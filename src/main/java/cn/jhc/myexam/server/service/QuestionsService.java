package cn.jhc.myexam.server.service;

import java.util.List;

import cn.jhc.myexam.shared.domain.QuestionType;

public interface QuestionsService {
	public List<?> findAllQuestion(QuestionType type);
}
