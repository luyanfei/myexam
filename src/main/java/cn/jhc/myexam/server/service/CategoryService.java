package cn.jhc.myexam.server.service;
import java.util.List;

import org.springframework.roo.addon.layers.service.RooService;

import cn.jhc.myexam.server.domain.Category;

@RooService(domainTypes = { cn.jhc.myexam.server.domain.Category.class })
public interface CategoryService {
	public List<Category> findChildren(Category parent);
}
