package cn.jhc.myexam.service;

import static org.junit.Assert.*;

import org.junit.Before;
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

}
