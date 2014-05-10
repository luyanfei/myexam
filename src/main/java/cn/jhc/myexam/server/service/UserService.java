package cn.jhc.myexam.server.service;
import java.util.Set;

import org.springframework.roo.addon.layers.service.RooService;

import cn.jhc.myexam.server.domain.Capability;
import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.server.domain.User;

@RooService(domainTypes = { cn.jhc.myexam.server.domain.User.class })
public interface UserService {
	public User findByUsername(String name);
	public Set<Capability> findCapabilities(User user);
	public Set<Category> findCategories(User user);
	public void addCategory(User user, Category category);
	public Category findDefaultCategory(String username);
}
