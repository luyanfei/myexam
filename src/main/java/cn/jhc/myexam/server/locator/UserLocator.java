package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.User;
import cn.jhc.myexam.server.service.UserService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.User")
@Component
public class UserLocator extends Locator<User, Long> {

    @Autowired
    UserService userService;

    public User create(Class<? extends cn.jhc.myexam.server.domain.User> clazz) {
        return new User();
    }

    public User find(Class<? extends cn.jhc.myexam.server.domain.User> clazz, Long id) {
        return userService.findUser(id);
    }

    public Class<User> getDomainType() {
        return User.class;
    }

    public Long getId(User user) {
        return user.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(User user) {
        return user.getVersion();
    }
}
