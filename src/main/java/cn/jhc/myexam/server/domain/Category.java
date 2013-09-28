package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "category_seq")
public class Category {

    /**
     */
    @NotNull
    @Size(min = 2, max = 32)
    private String name;

    /**
     */
    @Size(max = 1024)
    private String info;

    /**
     */
    @ManyToOne
    private Category parent;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "parent")
    private List<Category> children = new ArrayList<Category>();
}
