package cn.jhc.myexam.vaadin.window;

import java.util.Arrays;

import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder.EntityFormCallback;

import com.vaadin.data.fieldgroup.FieldGroup;
import com.vaadin.ui.ComboBox;
import com.vaadin.ui.FormLayout;

public class AddCategoryWindow extends FormWindow {

	public AddCategoryWindow() {
		setCaption("添加新的题库类别");
	}
	
	@Override
	protected FormLayout buildFormLayout() {
		FormLayout formLayout = VaadinEntityBuilder.create(Category.class)
				.buildFormLayout("添加新类别", new EntityFormCallback<Category>() {

					@Override
					public void onSave(Category item) {
					}

					@Override
					public void addCustomField(FormLayout formLayout,
							FieldGroup fieldGroup) {
						ComboBox box = new ComboBox("选择父类别",Arrays.asList("类别一","类别二"));
						fieldGroup.bind(box, "parent");
						formLayout.addComponent(box);
					}
				});
		return formLayout;
	}

}
