package cn.jhc.myexam.server.service;

import java.util.HashSet;
import java.util.Set;

import cn.jhc.myexam.server.domain.Capability;
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
}
