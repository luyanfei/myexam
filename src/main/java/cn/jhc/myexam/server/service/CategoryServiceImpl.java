package cn.jhc.myexam.server.service;

import java.util.List;

import cn.jhc.myexam.server.domain.Category;

public class CategoryServiceImpl implements CategoryService {
	public List<Category> findChildren(Category parent) {
		Category category = categoryRepository.save(parent);
		return category.getChildren();
	}
}
