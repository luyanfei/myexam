package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "role_seq")
public class Role {

    /**
     */
    @NotNull
    @Size(max = 64)
    private String rolename;

    /**
     */
    @ManyToOne
    private User user;
}
