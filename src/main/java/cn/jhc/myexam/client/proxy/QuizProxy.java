// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import java.util.Date;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "cn.jhc.myexam.server.domain.Quiz", locator = "cn.jhc.myexam.server.locator.QuizLocator")
@RooGwtProxy(value = "cn.jhc.myexam.server.domain.Quiz", readOnly = { "version", "id" }, scaffold = true)
public interface QuizProxy extends EntityProxy {

    abstract Long getId();

    abstract String getName();

    abstract void setName(String name);

    abstract String getInfo();

    abstract void setInfo(String info);

    abstract Date getTimeOpen();

    abstract void setTimeOpen(Date timeOpen);

    abstract Date getTimeClose();

    abstract void setTimeClose(Date timeClose);

    abstract String getContent();

    abstract void setContent(String content);

    abstract CategoryProxy getCategory();

    abstract void setCategory(CategoryProxy category);

    abstract Integer getVersion();
}
