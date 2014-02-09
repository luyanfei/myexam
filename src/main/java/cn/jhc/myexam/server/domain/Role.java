package cn.jhc.myexam.server.domain;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

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
    @Size(max = 2048)
    private String description;

    /**
     */
    @ManyToMany(cascade = CascadeType.ALL, mappedBy = "roles")
    private List<User> users = new ArrayList<User>();
}
