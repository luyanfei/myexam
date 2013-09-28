package cn.jhc.myexam.server.service;
import java.util.Date;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import cn.jhc.myexam.server.domain.Quiz;

@RooService(domainTypes = { cn.jhc.myexam.server.domain.Quiz.class })
public interface QuizService {
	public List<Quiz> findRunningQuizes(Date current);
}
