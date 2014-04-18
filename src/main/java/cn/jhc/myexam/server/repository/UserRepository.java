package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.User;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = User.class)
public interface UserRepository {
	public User findByUsername(String username);
}
