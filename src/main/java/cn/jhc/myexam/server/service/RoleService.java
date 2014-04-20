package cn.jhc.myexam.server.service;
import org.springframework.roo.addon.layers.service.RooService;

import cn.jhc.myexam.server.domain.Role;

@RooService(domainTypes = { cn.jhc.myexam.server.domain.Role.class })
public interface RoleService {
	public Role findByRolename(String rolename);
}
