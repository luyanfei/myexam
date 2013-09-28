package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.FillBlank;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = FillBlank.class)
public interface FillBlankRepository {
}
