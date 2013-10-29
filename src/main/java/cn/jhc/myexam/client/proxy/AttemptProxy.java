// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.proxy;
import cn.jhc.myexam.shared.domain.QuestionType;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Date;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "cn.jhc.myexam.server.domain.Attempt", locator = "cn.jhc.myexam.server.locator.AttemptLocator")
@RooGwtProxy(value = "cn.jhc.myexam.server.domain.Attempt", readOnly = { "version", "id" }, scaffold = true)
public interface AttemptProxy extends EntityProxy {

    abstract Long getId();

    abstract QuestionType getQuestionType();

    abstract void setQuestionType(QuestionType questionType);

    abstract String getAnswer();

    abstract void setAnswer(String answer);

    abstract Date getSubmitDate();

    abstract void setSubmitDate(Date submitDate);

    abstract UserProxy getUser();

    abstract void setUser(UserProxy user);

    abstract QuizProxy getQuiz();

    abstract void setQuiz(QuizProxy quiz);

    abstract Long getQuestionId();

    abstract void setQuestionId(Long questionId);

    abstract Integer getVersion();
}
