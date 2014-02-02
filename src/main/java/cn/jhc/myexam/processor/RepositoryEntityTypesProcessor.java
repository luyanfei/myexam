package cn.jhc.myexam.processor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import cn.jhc.myexam.server.domain.Attempt;
import cn.jhc.myexam.server.domain.BriefAnswer;
import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.server.domain.FillBlank;
import cn.jhc.myexam.server.domain.Glossary;
import cn.jhc.myexam.server.domain.Quiz;
import cn.jhc.myexam.server.domain.Role;
import cn.jhc.myexam.server.domain.SingleChoice;
import cn.jhc.myexam.server.domain.TrueOrFalse;
import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.repository.AttemptRepository;
import cn.jhc.myexam.server.repository.BriefAnswerRepository;
import cn.jhc.myexam.server.repository.CategoryRepository;
import cn.jhc.myexam.server.repository.FillBlankRepository;
import cn.jhc.myexam.server.repository.GlossaryRepository;
import cn.jhc.myexam.server.repository.QuizRepository;
import cn.jhc.myexam.server.repository.RoleRepository;
import cn.jhc.myexam.server.repository.SingleChoiceRepository;
import cn.jhc.myexam.server.repository.TrueOrFalseRepository;
import cn.jhc.myexam.server.repository.UserRepository;

@Component
public class RepositoryEntityTypesProcessor extends EntityTypesProcessor<JpaRepository<?, ?>> {
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
	@Autowired
	private AttemptRepository attemptRepository;
	@Autowired
	private QuizRepository quizRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private CategoryRepository categoryRepository;
	@Autowired
	private UserRepository userRepository;

	@Override
	public void handleAttempt(Attempt attempt) {
		setResult(attemptRepository);
	}

	@Override
	public void handleBriefAnswer(BriefAnswer briefAnswer) {
		setResult(briefAnswerRepository);
	}

	@Override
	public void handleCategory(Category category) {
		setResult(categoryRepository);
	}

	@Override
	public void handleFillBlank(FillBlank fillBlank) {
		setResult(fillBlankRepository);
	}

	@Override
	public void handleGlossary(Glossary glossary) {
		setResult(glossaryRepository);
	}

	@Override
	public void handleQuiz(Quiz quiz) {
		setResult(quizRepository);
	}

	@Override
	public void handleRole(Role role) {
		setResult(roleRepository);
	}

	@Override
	public void handleSingleChoice(SingleChoice singleChoice) {
		setResult(singleChoiceRepository);
	}

	@Override
	public void handleTrueOrFalse(TrueOrFalse trueOrFalse) {
		setResult(trueOrFalseRepository);
	}

	@Override
	public void handleUser(User user) {
		setResult(userRepository);
	}

}
