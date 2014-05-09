package cn.jhc.myexam.server.repository;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

import cn.jhc.myexam.server.domain.Category;

@RooJpaRepository(domainType = Category.class)
public interface CategoryRepository {
}
