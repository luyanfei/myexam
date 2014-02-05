package cn.jhc.myexam.vaadin.window;

import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder.EntityFormOkCallback;

import com.vaadin.ui.FormLayout;

public class AddCategoryWindow extends FormWindow {

	public AddCategoryWindow() {
		setCaption("添加新的题库类别");
	}
	
	@Override
	protected FormLayout buildFormLayout() {
		FormLayout formLayout = VaadinEntityBuilder.create(Category.class)
				.buildFormLayout("添加新类别", new EntityFormOkCallback<Category>() {

					@Override
					public void onSave(Category item) {
					}
				});
		return formLayout;
	}

}
