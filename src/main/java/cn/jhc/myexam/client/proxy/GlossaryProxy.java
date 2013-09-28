// WARNING: THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.proxy;
import com.google.web.bindery.requestfactory.shared.EntityProxy;
import com.google.web.bindery.requestfactory.shared.ProxyForName;
import org.springframework.roo.addon.gwt.RooGwtProxy;

@ProxyForName(value = "cn.jhc.myexam.server.domain.Glossary", locator = "cn.jhc.myexam.server.locator.GlossaryLocator")
@RooGwtProxy(value = "cn.jhc.myexam.server.domain.Glossary", readOnly = { "version", "id" }, scaffold = true)
public interface GlossaryProxy extends EntityProxy {

    abstract Long getId();

    abstract String getTerm();

    abstract void setTerm(String term);

    abstract String getDefination();

    abstract void setDefination(String defination);

    abstract CategoryProxy getCategory();

    abstract void setCategory(CategoryProxy category);

    abstract Integer getVersion();
}
