package cn.jhc.myexam.server.domain;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = Role.class)
public class RoleIntegrationTest {

    @Test
    public void testFindByRolename() {
    	Role role = dod.getSpecificRole(0);
    	Role role2 = roleService.findByRolename(role.getRolename());
    	assertEquals(role.getRolename(), role2.getRolename());
    	assertEquals(role.getDescription(), role2.getDescription());
    }
}
