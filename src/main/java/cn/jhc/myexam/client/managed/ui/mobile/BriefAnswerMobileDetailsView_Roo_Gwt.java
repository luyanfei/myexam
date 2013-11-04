// WARNING: DO NOT EDIT THIS FILE. THIS FILE IS MANAGED BY SPRING ROO.

package cn.jhc.myexam.client.managed.ui.mobile;
import cn.jhc.myexam.client.managed.ui.BriefAnswerDetailsView;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
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

public abstract class BriefAnswerMobileDetailsView_Roo_Gwt extends Composite implements BriefAnswerDetailsView {

    @UiField
    Element id;

    @UiField
    Element question;

    @UiField
    Element answer;

    @UiField
    Element category;

    @UiField
    Element uploadFile;

    @UiField
    Element version;

    BriefAnswerProxy proxy;

    public void setValue(BriefAnswerProxy proxy) {
        this.proxy = proxy;
        id.setInnerText(proxy.getId() == null ? "" : String.valueOf(proxy.getId()));
        question.setInnerText(proxy.getQuestion() == null ? "" : String.valueOf(proxy.getQuestion()));
        answer.setInnerText(proxy.getAnswer() == null ? "" : String.valueOf(proxy.getAnswer()));
        category.setInnerText(proxy.getCategory() == null ? "" : cn.jhc.myexam.client.managed.ui.renderer.CategoryProxyRenderer.instance().render(proxy.getCategory()));
        uploadFile.setInnerText(proxy.getUploadFile() == null ? "" : String.valueOf(proxy.getUploadFile()));
        version.setInnerText(proxy.getVersion() == null ? "" : String.valueOf(proxy.getVersion()));
    }
}
