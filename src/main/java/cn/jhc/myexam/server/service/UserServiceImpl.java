package cn.jhc.myexam.server.service;

import java.util.HashSet;
import java.util.Set;

import cn.jhc.myexam.server.domain.Capability;
import cn.jhc.myexam.server.domain.Category;
import cn.jhc.myexam.server.domain.Role;
import cn.jhc.myexam.server.domain.User;

public class UserServiceImpl implements UserService {
	
	public User findByUsername(String name) {
		return userRepository.findByUsername(name);
	}
	
	@Override
	public Set<Capability> findCapabilities(User user) {
		Set<Capability> capabilities = new HashSet<Capability>();
		for(Role role : user.getRoles()) {
			for(Capability c : role.getCapabilities())
				capabilities.add(c);
		}
		return capabilities;
	}
	
	public Set<Category> findCategories(User user) {
		User user2 = userRepository.findOne(user.getId());
		return user2.getCategories();
	}
	
	public void addCategory(User user, Category category) {
		User u = userRepository.findOne(user.getId());
		u.getCategories().add(category);
		userRepository.save(u);
	}
	
	public Category findDefaultCategory(String username) {
		return userRepository.findDefaultCategory(username);
	}
}
