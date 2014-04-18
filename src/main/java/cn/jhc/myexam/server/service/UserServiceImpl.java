package cn.jhc.myexam.server.service;

import cn.jhc.myexam.server.domain.User;

public class UserServiceImpl implements UserService {
	public User findByUsername(String name) {
		return userRepository.findByUsername(name);
	}
}
