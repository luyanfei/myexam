package cn.jhc.myexam.vaadin.factory;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.vaadin.ui.Table;

import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.vaadin.builder.VaadinEntityBuilder;

import java.util.ArrayList;
import java.util.List;

public class EntityBuilderFactoryTest {
	
	private List<User> list = null;

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
	}

	@Test
	public void testGetEntityTable() {
		Table t = EntityBuilderFactory.getEntityBuilder(User.class).buildTable(list); 
		assertEquals(4, t.getVisibleColumns().length);
	}

	@Test
	public void testGetEntityTableClassOfTCollectionOfTDeleteCallbackOfT() {
		
	}

}
