package cn.jhc.myexam.server.repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.server.domain.User;

@RooJpaRepository(domainType = User.class)
public interface UserRepository {
	public User findByUsername(String username);
	
	/**
	 * Default category has the same name as username. Every user can has just one default category.
	 * @param username
	 * @return
	 */
	@Query("select c from User u join u.categories c where u.username=?1 and c.name=?1")
	public Category findDefaultCategory(String username);
}
