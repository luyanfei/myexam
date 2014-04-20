package cn.jhc.myexam.server.repository;
import cn.jhc.myexam.server.domain.Capability;
import org.springframework.roo.addon.layers.repository.jpa.RooJpaRepository;

@RooJpaRepository(domainType = Capability.class)
public interface CapabilityRepository {
}
