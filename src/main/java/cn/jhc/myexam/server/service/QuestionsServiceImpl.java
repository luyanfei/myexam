package cn.jhc.myexam.server.service;

import static cn.jhc.myexam.shared.domain.QuestionType.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import cn.jhc.myexam.server.repository.BriefAnswerRepository;
import cn.jhc.myexam.server.repository.FillBlankRepository;
import cn.jhc.myexam.server.repository.GlossaryRepository;
import cn.jhc.myexam.server.repository.SingleChoiceRepository;
import cn.jhc.myexam.server.repository.TrueOrFalseRepository;
import cn.jhc.myexam.shared.domain.QuestionType;

@Service @Transactional
public class QuestionsServiceImpl implements QuestionsService {

	@Autowired
	private SingleChoiceRepository singleChoiceRepository;
	@Autowired
	private GlossaryRepository glossaryRepository;
	@Autowired
	private FillBlankRepository fillBlankRepository;
	@Autowired
	private BriefAnswerRepository briefAnswerRepository;
	@Autowired
	private TrueOrFalseRepository trueOrFalseRepository;
	
	public List<?> findAllQuestion(QuestionType type) {
		if(type == SINGLE_CHOICE)
			return singleChoiceRepository.findAll();
		if(type == GLOSSARY)
			return glossaryRepository.findAll();
		if(type == FILL_BLANK)
			return fillBlankRepository.findAll();
		if(type == BRIEF_ANSWER)
			return briefAnswerRepository.findAll();
		if(type == TRUE_OR_FALSE)
			return trueOrFalseRepository.findAll();
		return null;
	}
}
