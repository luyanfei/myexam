package cn.jhc.myexam.server.service;

import java.util.Date;
import java.util.List;

import cn.jhc.myexam.server.domain.Quiz;

public class QuizServiceImpl implements QuizService {
	public List<Quiz> findRunningQuizes(Date current){
		return quizRepository.findRunningQuizes(current);
	}
}
