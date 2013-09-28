// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "cn.jhc.myexam.server.domain.TrueOrFalse", locator = "cn.jhc.myexam.server.locator.TrueOrFalseLocator")
@RooGwtProxy(value = "cn.jhc.myexam.server.domain.TrueOrFalse", readOnly = { "version", "id" }, scaffold = true)
public interface TrueOrFalseProxy extends EntityProxy {

    abstract Long getId();

    abstract String getQuestion();

    abstract void setQuestion(String question);

    abstract Boolean getAnswer();

    abstract void setAnswer(Boolean answer);

    abstract CategoryProxy getCategory();

    abstract void setCategory(CategoryProxy category);

    abstract Integer getVersion();
}
