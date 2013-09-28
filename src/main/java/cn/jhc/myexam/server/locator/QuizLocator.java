package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.Quiz;
import cn.jhc.myexam.server.service.QuizService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.Quiz")
@Component
public class QuizLocator extends Locator<Quiz, Long> {

    @Autowired
    QuizService quizService;

    public Quiz create(Class<? extends cn.jhc.myexam.server.domain.Quiz> clazz) {
        return new Quiz();
    }

    public Quiz find(Class<? extends cn.jhc.myexam.server.domain.Quiz> clazz, Long id) {
        return quizService.findQuiz(id);
    }

    public Class<Quiz> getDomainType() {
        return Quiz.class;
    }

    public Long getId(Quiz quiz) {
        return quiz.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Quiz quiz) {
        return quiz.getVersion();
    }
}
