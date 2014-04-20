package cn.jhc.myexam.server.domain;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.roo.addon.test.RooIntegrationTest;

@RooIntegrationTest(entity = User.class)
public class UserIntegrationTest {

    @Test
    public void testFindCapabilities() {
    	User user = dod.getSpecificUser(0);
    	int size = userService.findCapabilities(user).size();
    	assertEquals(5, size);
    }
}
