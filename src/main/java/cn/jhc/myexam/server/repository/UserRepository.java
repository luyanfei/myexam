package cn.jhc.myexam.server.repository;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import cn.jhc.myexam.server.domain.User;

@RooJpaRepository(domainType = User.class)
public interface UserRepository {
	public User findByUsername(String username);
}
