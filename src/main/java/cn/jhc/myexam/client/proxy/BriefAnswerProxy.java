// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "cn.jhc.myexam.server.domain.BriefAnswer", locator = "cn.jhc.myexam.server.locator.BriefAnswerLocator")
@RooGwtProxy(value = "cn.jhc.myexam.server.domain.BriefAnswer", readOnly = { "version", "id" }, scaffold = true)
public interface BriefAnswerProxy extends EntityProxy {

    abstract Long getId();

    abstract String getQuestion();

    abstract void setQuestion(String question);

    abstract String getAnswer();

    abstract void setAnswer(String answer);

    abstract CategoryProxy getCategory();

    abstract void setCategory(CategoryProxy category);

    abstract Integer getVersion();
}
