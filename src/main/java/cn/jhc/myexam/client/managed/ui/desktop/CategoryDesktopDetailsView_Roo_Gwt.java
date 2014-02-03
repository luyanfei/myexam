// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.managed.ui.desktop;
import cn.jhc.myexam.client.managed.ui.CategoryDetailsView;
import cn.jhc.myexam.client.managed.ui.editor.CategoryListEditor;
import cn.jhc.myexam.client.managed.ui.editor.UserSetEditor;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import cn.jhc.myexam.client.scaffold.place.ProxyListView;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.SpanElement;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.HasClickHandlers;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Widget;
import java.util.List;
import java.util.Set;

public abstract class CategoryDesktopDetailsView_Roo_Gwt extends Composite implements CategoryDetailsView {

    @UiField
    SpanElement id;

    @UiField
    SpanElement name;

    @UiField
    SpanElement info;

    @UiField
    SpanElement parent;

    @UiField
    SpanElement children;

    @UiField
    SpanElement users;

    @UiField
    SpanElement version;

    CategoryProxy proxy;

    @UiField
    SpanElement displayRenderer;

    public void setValue(CategoryProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        name.setInnerText(proxy.getName() == null ? "" : String.valueOf(proxy.getName()));
        info.setInnerText(proxy.getInfo() == null ? "" : String.valueOf(proxy.getInfo()));
        parent.setInnerText(proxy.getParent() == null ? "" : cn.jhc.myexam.client.managed.ui.renderer.CategoryProxyRenderer.instance().render(proxy.getParent()));
        children.setInnerText(proxy.getChildren() == null ? "" : cn.jhc.myexam.client.scaffold.place.CollectionRenderer.of(cn.jhc.myexam.client.managed.ui.renderer.CategoryProxyRenderer.instance()).render(proxy.getChildren()));
        users.setInnerText(proxy.getUsers() == null ? "" : cn.jhc.myexam.client.scaffold.place.CollectionRenderer.of(cn.jhc.myexam.client.managed.ui.renderer.UserProxyRenderer.instance()).render(proxy.getUsers()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
        displayRenderer.setInnerText(cn.jhc.myexam.client.managed.ui.renderer.CategoryProxyRenderer.instance().render(proxy));
    }
}
