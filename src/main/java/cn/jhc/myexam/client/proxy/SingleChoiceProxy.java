// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "cn.jhc.myexam.server.domain.SingleChoice", locator = "cn.jhc.myexam.server.locator.SingleChoiceLocator")
@RooGwtProxy(value = "cn.jhc.myexam.server.domain.SingleChoice", readOnly = { "version", "id" }, scaffold = true)
public interface SingleChoiceProxy extends EntityProxy {

    abstract Long getId();

    abstract String getQuestion();

    abstract void setQuestion(String question);

    abstract String getOptionA();

    abstract void setOptionA(String optionA);

    abstract String getOptionB();

    abstract void setOptionB(String optionB);

    abstract String getOptionC();

    abstract void setOptionC(String optionC);

    abstract String getOptionD();

    abstract void setOptionD(String optionD);

    abstract String getAnswer();

    abstract void setAnswer(String answer);

    abstract CategoryProxy getCategory();

    abstract void setCategory(CategoryProxy category);

    abstract Integer getVersion();
}
