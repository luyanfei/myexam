package cn.jhc.myexam.server.service;

import cn.jhc.myexam.server.domain.Role;

public class RoleServiceImpl implements RoleService {

	@Override
	public Role findByRolename(String rolename) {
		return roleRepository.findByRolename(rolename);
	}
}
