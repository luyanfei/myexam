// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.managed.ui.mobile;
import cn.jhc.myexam.client.managed.ui.UserDetailsView;
import cn.jhc.myexam.client.managed.ui.editor.CategorySetEditor;
import cn.jhc.myexam.client.managed.ui.editor.RoleListEditor;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.proxy.RoleProxy;
import cn.jhc.myexam.client.proxy.UserProxy;
import com.google.gwt.core.client.GWT;
import com.google.gwt.dom.client.Element;
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

public abstract class UserMobileDetailsView_Roo_Gwt extends Composite implements UserDetailsView {

    @UiField
    Element id;

    @UiField
    Element username;

    @UiField
    Element password;

    @UiField
    Element enabled;

    @UiField
    Element displayName;

    @UiField
    Element roles;

    @UiField
    Element categories;

    @UiField
    Element version;

    UserProxy proxy;

    public void setValue(UserProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        username.setInnerText(proxy.getUsername() == null ? "" : String.valueOf(proxy.getUsername()));
        password.setInnerText(proxy.getPassword() == null ? "" : String.valueOf(proxy.getPassword()));
        enabled.setInnerText(proxy.getEnabled() == null ? "" : String.valueOf(proxy.getEnabled()));
        displayName.setInnerText(proxy.getDisplayName() == null ? "" : String.valueOf(proxy.getDisplayName()));
        roles.setInnerText(proxy.getRoles() == null ? "" : cn.jhc.myexam.client.scaffold.place.CollectionRenderer.of(cn.jhc.myexam.client.managed.ui.renderer.RoleProxyRenderer.instance()).render(proxy.getRoles()));
        categories.setInnerText(proxy.getCategories() == null ? "" : cn.jhc.myexam.client.scaffold.place.CollectionRenderer.of(cn.jhc.myexam.client.managed.ui.renderer.CategoryProxyRenderer.instance()).render(proxy.getCategories()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
    }
}
