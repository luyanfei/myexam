package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.Category;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Category.class)
public interface CategoryRepository {
}
