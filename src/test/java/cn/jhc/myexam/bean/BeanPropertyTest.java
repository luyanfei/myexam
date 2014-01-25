package cn.jhc.myexam.bean;

import static org.junit.Assert.assertEquals;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;

import org.junit.Test;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;

import cn.jhc.myexam.server.domain.User;

public class BeanPropertyTest {

	@Test
	public void testStandardPropertyEditors() throws IntrospectionException {
		BeanInfo beanInfo = Introspector.getBeanInfo(User.class);
		PropertyDescriptor[] descriptors = beanInfo.getPropertyDescriptors();
		for (PropertyDescriptor p : descriptors) {
			System.out.println(p.getPropertyType() + "\t" + p.getPropertyEditorClass());
			System.out.println(p.getReadMethod() + "\t" + p.getWriteMethod());
		}
	}
	
	@Test
	public void testSpringBeanWrapper() {
		BeanWrapper wrapper = new BeanWrapperImpl(User.class);
		wrapper.setPropertyValue("username","张三");
		User user = (User)wrapper.getWrappedInstance();
		assertEquals("张三", user.getUsername());
	}
}
