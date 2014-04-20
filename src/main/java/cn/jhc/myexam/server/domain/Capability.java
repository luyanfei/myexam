package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "capability_seq")
public class Capability {

    /**
     */
    @NotNull
    @Size(min = 2, max = 128)
    private String name;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "capabilities")
    private Set<Role> roles = new HashSet<Role>();
}
