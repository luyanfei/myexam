package cn.jhc.myexam.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.server.domain.CategoryDataOnDemand;
import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.domain.UserDataOnDemand;
import cn.jhc.myexam.server.service.CategoryService;
import cn.jhc.myexam.server.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
@Transactional
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private UserDataOnDemand userDataOnDemand;
	
	@Autowired
	private CategoryDataOnDemand categoryDataOnDemand;

	@Test
	public void testAddCategory() {
		User user = userDataOnDemand.getSpecificUser(0);
		Category category = categoryDataOnDemand.getRandomCategory();
		userService.addCategory(user, category);
		User user2 = userService.findUser(user.getId());
		Category category2 = user2.getCategories().iterator().next();
		assertEquals(category2.getId(), category.getId());
	}

	@Test
	public void testFindDefaultCategory() {
		User user = userDataOnDemand.getSpecificUser(0);
		Category c = userService.findDefaultCategory(user.getUsername());
		assertNull(c);
		
		Category category = categoryDataOnDemand.getRandomCategory();
		category.setName(user.getUsername());
		userService.addCategory(user, category);
		Category category2 = userService.findDefaultCategory(user.getUsername());
		assertEquals(category.getInfo(), category2.getInfo());
		assertEquals(category.getId(), category2.getId());
	}
	
	@Test
	public void testFindChildren() {
		Category c1 = categoryDataOnDemand.getNewTransientCategory(0);
		Category c2 = categoryDataOnDemand.getNewTransientCategory(1);
		c1.getChildren().add(c2);
		c2.setParent(c1);
		categoryService.saveCategory(c1);
		assertNotNull(c1.getId());
		assertNotNull(c2.getId());

		Category nc1 = categoryService.findCategory(c1.getId());
		assertEquals(c1.getId(), nc1.getId());
		Category child = categoryService.findChildren(nc1).get(0);
		assertEquals(c2.getName(), child.getName());
		assertEquals(c2.getInfo(), child.getInfo());
		assertEquals(c2.getId(), child.getId());
		assertEquals(c1.getId(), child.getParent().getId());
	}
}
