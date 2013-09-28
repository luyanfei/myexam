package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "user_seq")
public class User {

    /**
     */
    @NotNull
    @Column(unique = true)
    @Size(max = 64)
    private String username;

    /**
     */
    @NotNull
    @Size(max = 1024)
    private String password;

    /**
     */
    @NotNull
    private Boolean enabled;

    /**
     */
    @Size(max = 128)
    private String displayName;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Role> roles = new ArrayList<Role>();
}
