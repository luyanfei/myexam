package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "fill_blank_seq")
public class FillBlank {

    /**
     */
    @NotNull
    @Size(max = 2048)
    private String question;

    /**
     */
    @NotNull
    private Integer quantity;

    /**
     */
    @Size(max = 2048)
    private String answer;

    /**
     */
    @NotNull
    @ManyToOne
    private Category category;
}
