package cn.jhc.myexam.vaadin.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vaadin.ui.FormLayout;
import com.vaadin.ui.Table;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder.EntityFormOkCallback;

import java.util.ArrayList;
import java.util.List;

public class EntityBuilderFactoryTest {
	
	private List<User> list = null;
	private VaadinEntityBuilder<User> userBuilder;

	@Before
	public void setUp() throws Exception {
		User user1 = new User();
		user1.setId(1L);
		user1.setUsername("user1");
		user1.setDisplayName("zhangshang");
		
		User user2 = new User();
		user2.setId(2L);
		user2.setUsername("user2");
		user2.setDisplayName("lishi");
		
		list = new ArrayList<User>();
		list.add(user1);
		list.add(user2);
		
		userBuilder = VaadinEntityBuilder.create(User.class);
	}

	@Test
	public void testGetEntityTable() {
		Table t = userBuilder.buildTable(list); 
		assertEquals(userBuilder.getPropertyNameList().size(), t.getVisibleColumns().length);
		assertArrayEquals(userBuilder.getPropertyNameList().toArray(), t.getVisibleColumns());
	}

	@Test
	public void testGetFormLayout() {
		FormLayout formLayout = userBuilder.buildFormLayout("Test caption", new EntityFormOkCallback<User>() {

			@Override
			public void onSave(User item) {
				
			}
		});
		assertEquals(userBuilder.getPropertyNameList().size() + 1, formLayout.getComponentCount());
	}

}
