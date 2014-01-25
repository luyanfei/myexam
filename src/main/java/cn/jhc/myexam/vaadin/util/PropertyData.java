package cn.jhc.myexam.vaadin.util;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import cn.jhc.myexam.annotation.Description;

public class PropertyData {
	private List<String> propertyNameList;
	private List<String> descriptionList;

	public PropertyData(Class<?> clazz) {
		propertyNameList = new ArrayList<String>();
		descriptionList = new ArrayList<String>();
		for(Field field : clazz.getDeclaredFields()) {
			Description description = field.getAnnotation(Description.class);
			if(description != null) {
				propertyNameList.add(field.getName());
				descriptionList.add(description.value());
			}
		}
	}

	public List<String> getPropertyNameList() {
		return propertyNameList;
	}

	public List<String> getDescriptionList() {
		return descriptionList;
	}
}