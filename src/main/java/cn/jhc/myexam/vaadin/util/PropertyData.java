package cn.jhc.myexam.vaadin.util;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import cn.jhc.myexam.annotation.Description;
import cn.jhc.myexam.annotation.ImportColumn;

public class PropertyData implements Serializable {
	private static final long serialVersionUID = 4374520611899215576L;
	/**
	 * Every entity class just need only one PropertyData object.
	 */
	private static final Map<String, PropertyData> map = new ConcurrentHashMap<String, PropertyData>();
	
	public static PropertyData create(Class<?> clazz) {
		String className = clazz.getName();
		PropertyData data = null;
		data = map.get(className);
		if(data == null) {
			data = new PropertyData(clazz);
			map.put(className, data);
		}
		return data;
	}

	private List<String> propertyNameList = new ArrayList<String>();
	private List<String> descriptionList = new ArrayList<String>();
	private List<String> importColumnList = new ArrayList<String>();
	
	private Map<String, String> columnToProperty = new HashMap<String, String>();

	private PropertyData(Class<?> clazz) {
		for(Field field : clazz.getDeclaredFields()) {
			Description description = field.getAnnotation(Description.class);
			ImportColumn importColumn = field.getAnnotation(ImportColumn.class);
			if(description != null) {
				propertyNameList.add(field.getName());
				descriptionList.add(description.value());
				if(importColumn != null) {
					importColumnList.add(description.value());
					columnToProperty.put(description.value(), field.getName());
				}
			}
		}
	}

	public String getPropertyNameByColumn(String columnName) {
		return columnToProperty.get(columnName);
	}
	
	public List<String> getPropertyNameList() {
		return propertyNameList;
	}

	public List<String> getDescriptionList() {
		return descriptionList;
	}

	public List<String> getImportColumnList() {
		return importColumnList;
	}
}