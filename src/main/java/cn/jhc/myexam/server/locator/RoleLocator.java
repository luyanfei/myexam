package cn.jhc.myexam.server.locator;
import cn.jhc.myexam.server.domain.Role;
import cn.jhc.myexam.server.service.RoleService;
import com.google.web.bindery.requestfactory.shared.Locator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.roo.addon.gwt.RooGwtLocator;
import org.springframework.stereotype.Component;

@RooGwtLocator("cn.jhc.myexam.server.domain.Role")
@Component
public class RoleLocator extends Locator<Role, Long> {

    @Autowired
    RoleService roleService;

    public Role create(Class<? extends cn.jhc.myexam.server.domain.Role> clazz) {
        return new Role();
    }

    public Role find(Class<? extends cn.jhc.myexam.server.domain.Role> clazz, Long id) {
        return roleService.findRole(id);
    }

    public Class<Role> getDomainType() {
        return Role.class;
    }

    public Long getId(Role role) {
        return role.getId();
    }

    public Class<Long> getIdType() {
        return Long.class;
    }

    public Object getVersion(Role role) {
        return role.getVersion();
    }
}
