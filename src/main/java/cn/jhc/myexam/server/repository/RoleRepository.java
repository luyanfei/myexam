package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.Role;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Role.class)
public interface RoleRepository {
	public Role findByRolename(String rolename);
}
