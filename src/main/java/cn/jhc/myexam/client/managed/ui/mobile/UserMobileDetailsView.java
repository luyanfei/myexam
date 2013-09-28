package cn.jhc.myexam.client.managed.ui.mobile;
import cn.jhc.myexam.client.managed.ui.UserDetailsView;
import cn.jhc.myexam.client.managed.ui.editor.RoleListEditor;
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

public class UserMobileDetailsView extends UserMobileDetailsView_Roo_Gwt {

    private static final Binder BINDER = GWT.create(Binder.class);

    private static UserMobileDetailsView instance;

    @UiField
    HasClickHandlers delete;

    private Delegate delegate;

    public UserMobileDetailsView() {
        initWidget(BINDER.createAndBindUi(this));
    }

    public static UserMobileDetailsView instance() {
        if (instance == null) {
            instance = new UserMobileDetailsView();
        }
        return instance;
    }

    public Widget asWidget() {
        return this;
    }

    public boolean confirm(String msg) {
        return Window.confirm(msg);
    }

    public UserProxy getValue() {
        return proxy;
    }

    @UiHandler("delete")
    public void onDeleteClicked(ClickEvent e) {
        delegate.deleteClicked();
    }

    public void setDelegate(Delegate delegate) {
        this.delegate = delegate;
    }

    interface Binder extends UiBinder<HTMLPanel, UserMobileDetailsView> {
    }
}
