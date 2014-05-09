package cn.jhc.myexam.data;

import static org.junit.Assert.*;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.data.jpa.repository.support.JpaMetamodelEntityInformation;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.jhc.myexam.server.domain.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:/META-INF/spring/applicationContext*.xml")
public class JpaMetamodelEntityInfomationTest {
	
	JpaMetamodelEntityInformation<User, Long> entityInformation;

	@PersistenceContext
	EntityManager entityManager;
	
	@Before
	public void setUp() throws Exception {
		entityInformation = new JpaMetamodelEntityInformation<User, Long>(User.class, entityManager.getMetamodel());
	}

	@Test
	public void testGetId() {
		User u = new User();
		u.setId(1L);
		u.setUsername("testuser");
		assertEquals(new Long(1L), entityInformation.getId(u));
		assertFalse(entityInformation.isNew(u));
	}

}
