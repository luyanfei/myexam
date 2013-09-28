package cn.jhc.myexam.client.managed.ui.editor;
import cn.jhc.myexam.client.proxy.BriefAnswerProxy;
import cn.jhc.myexam.client.proxy.CategoryProxy;
import cn.jhc.myexam.client.scaffold.ui.CollectionRenderer;
import com.google.gwt.core.client.GWT;
import com.google.gwt.editor.client.Editor;
import com.google.gwt.editor.client.Editor.Ignore;
import com.google.gwt.editor.client.EditorDelegate;
import com.google.gwt.editor.client.LeafValueEditor;
import com.google.gwt.editor.client.ValueAwareEditor;
import com.google.gwt.editor.client.adapters.EditorSource;
import com.google.gwt.editor.client.adapters.ListEditor;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.event.shared.HandlerRegistration;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.ValueListBox;
import com.google.gwt.user.client.ui.Widget;
import com.google.web.bindery.requestfactory.gwt.client.RequestFactoryEditorDriver;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class BriefAnswerListEditor extends BriefAnswerListEditor_Roo_Gwt {

    @UiField
    FlowPanel container;

    @UiField(provided = true)
    @Ignore
    ValueListBox<BriefAnswerProxy> picker = new ValueListBox<BriefAnswerProxy>(cn.jhc.myexam.client.managed.ui.renderer.BriefAnswerProxyRenderer.instance(), new com.google.web.bindery.requestfactory.gwt.ui.client.EntityProxyKeyProvider<BriefAnswerProxy>());

    @UiField
    Button add;

    @UiField
    HTMLPanel editorPanel;

    @UiField
    Button clickToEdit;

    @UiField
    HTMLPanel viewPanel;

    @UiField
    Label viewLabel;

    @UiField
    Style style;

    boolean editing = false;

    private List<BriefAnswerProxy> values;

    private final List<BriefAnswerProxy> displayedList;

    public BriefAnswerListEditor() {
        // Create the UI
        initWidget(GWT.<Binder>create(Binder.class).createAndBindUi(this));
        // Create the driver which manages the data-bound widgets
        Driver driver = GWT.<Driver>create(Driver.class);
        // Use a ListEditor that uses our NameLabelSource
        ListEditor<BriefAnswerProxy, NameLabel> listEditor = ListEditor.of(new NameLabelSource());
        // Configure the driver
        driver.initialize(listEditor);
        /*
         * Notice the backing list is essentially anonymous.
         */
        driver.display(new ArrayList<BriefAnswerProxy>());
        // Modifying this list triggers widget creation and destruction
        displayedList = listEditor.getList();
        editing = false;
    }

    @UiHandler("add")
    public void addClicked(ClickEvent e) {
        if (picker.getValue() == null) {
            return;
        }
        for (BriefAnswerProxy proxy : displayedList) {
            if (proxy.getQuestion().equals(picker.getValue().getQuestion())) {
                return;
            }
        }
        displayedList.add(picker.getValue());
        viewLabel.setText(makeFlatList(displayedList));
    }

    @UiHandler("clickToEdit")
    public void clickToEditClicked(ClickEvent e) {
        toggleEditorMode();
    }

    @Override
    public void flush() {
    }

    @Override
    public List<BriefAnswerProxy> getValue() {
        if (values == null && displayedList.size() == 0) {
            return null;
        }
        return new ArrayList<BriefAnswerProxy>(displayedList);
    }

    public void onLoad() {
        makeEditable(false);
    }

    @Override
    public void onPropertyChange(String... strings) {
    }

    public void setAcceptableValues(Collection<BriefAnswerProxy> proxies) {
        picker.setAcceptableValues(proxies);
    }

    @Override
    public void setDelegate(EditorDelegate<List<BriefAnswerProxy>> editorDelegate) {
    }

    @Override
    public void setValue(List<BriefAnswerProxy> values) {
        this.values = values;
        makeEditable(editing = false);
        if (displayedList != null) {
            displayedList.clear();
            if (values != null) {
                for (BriefAnswerProxy e : values) {
                    displayedList.add(e);
                }
            }
        }
        viewLabel.setText(makeFlatList(values));
    }

    private void makeEditable(boolean editable) {
        if (editable) {
            editorPanel.setStylePrimaryName(style.editorPanelVisible());
            viewPanel.setStylePrimaryName(style.viewPanelHidden());
            clickToEdit.setText("Done");
        } else {
            editorPanel.setStylePrimaryName(style.editorPanelHidden());
            viewPanel.setStylePrimaryName(style.viewPanelVisible());
            clickToEdit.setText("Edit");
        }
    }

    private String makeFlatList(Collection<BriefAnswerProxy> values) {
        return CollectionRenderer.of(cn.jhc.myexam.client.managed.ui.renderer.BriefAnswerProxyRenderer.instance()).render(values);
    }

    private void toggleEditorMode() {
        editing = !editing;
        makeEditable(editing);
    }

    interface Binder extends UiBinder<Widget, BriefAnswerListEditor> {
    }

    interface Driver extends RequestFactoryEditorDriver<List<BriefAnswerProxy>, ListEditor<BriefAnswerProxy, NameLabel>> {
    }

    class NameLabel extends Composite implements LeafValueEditor<BriefAnswerProxy> {

        final Label questionEditor = new Label();

        private BriefAnswerProxy proxy = null;

        public NameLabel() {
            this(null);
        }

        public NameLabel(EventBus eventBus) {
            initWidget(questionEditor);
        }

        public void setValue(BriefAnswerProxy proxy) {
            this.proxy = proxy;
            questionEditor.setText(cn.jhc.myexam.client.managed.ui.renderer.BriefAnswerProxyRenderer.instance().render(proxy));
        }

        @Override
        public BriefAnswerProxy getValue() {
            return proxy;
        }
    }

    interface Style extends CssResource {

        String editorPanelHidden();

        String editorPanelVisible();

        String viewPanelHidden();

        String viewPanelVisible();
    }

    private class NameLabelSource extends EditorSource<NameLabel> {

        @Override
        public NameLabel create(int index) {
            NameLabel label = new NameLabel();
            container.insert(label, index);
            return label;
        }

        @Override
        public void dispose(NameLabel subEditor) {
            subEditor.removeFromParent();
        }

        @Override
        public void setIndex(NameLabel editor, int index) {
            container.insert(editor, index);
        }
    }
}
