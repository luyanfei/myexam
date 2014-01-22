package cn.jhc.myexam.client.managed.ui.mobile;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.scaffold.ScaffoldMobileApp;
import cn.jhc.myexam.client.scaffold.ui.MobileProxyListView;
import com.google.gwt.i18n.client.DateTimeFormat;
import com.google.gwt.i18n.client.NumberFormat;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.safehtml.shared.SafeHtmlBuilder;
import com.google.gwt.safehtml.shared.SafeHtmlUtils;
import com.google.gwt.text.client.DateTimeFormatRenderer;
import com.google.gwt.text.shared.AbstractRenderer;
import com.google.gwt.text.shared.AbstractSafeHtmlRenderer;
import com.google.gwt.text.shared.Renderer;
import com.google.gwt.text.shared.SafeHtmlRenderer;
import java.util.HashSet;
import java.util.Set;

public class BriefAnswerMobileListView extends BriefAnswerMobileListView_Roo_Gwt {

    private static BriefAnswerMobileListView instance;

    public BriefAnswerMobileListView() {
        super("New BRIEF_ANSWER", new CellRenderer());
        init();
    }

    public static BriefAnswerMobileListView instance() {
        if (instance == null) {
            instance = new BriefAnswerMobileListView();
        }
        return instance;
    }

    public String[] getPaths() {
        return paths.toArray(new String[paths.size()]);
    }

    private static class CellRenderer extends AbstractSafeHtmlRenderer<BriefAnswerProxy> {

        private final String dateStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().dateProp();

        private final String secondaryStyle = ScaffoldMobileApp.getMobileListResources().cellListStyle().secondaryProp();

        private final Renderer<BriefAnswerProxy> primaryRenderer = cn.jhc.myexam.client.managed.ui.renderer.BriefAnswerProxyRenderer.instance();

        private final Renderer<String> secondaryRenderer = new AbstractRenderer<String>() {

            public String render(java.lang.String obj) {
                return obj == null ? "" : String.valueOf(obj);
            }
        };

        @Override
        public SafeHtml render(BriefAnswerProxy value) {
            if (value == null) {
                return SafeHtmlUtils.EMPTY_SAFE_HTML;
            }
            // Primary property.
            SafeHtmlBuilder sb = new SafeHtmlBuilder();
            if (value != null) {
                sb.appendEscaped(primaryRenderer.render(value));
            }
            // Secondary property.
            sb.appendHtmlConstant("<div style=\"position:relative;\">");
            sb.appendHtmlConstant("<div class=\"" + secondaryStyle + "\">");
            if (value.getAnswer() != null) {
                sb.appendEscaped(secondaryRenderer.render(value.getAnswer()));
            }
            sb.appendHtmlConstant("</div>");
            // Date property.
            sb.appendHtmlConstant("<div class=\"" + dateStyle + "\">");
            sb.appendHtmlConstant("</div>");
            sb.appendHtmlConstant("</div>");
            return sb.toSafeHtml();
        }
    }
}
