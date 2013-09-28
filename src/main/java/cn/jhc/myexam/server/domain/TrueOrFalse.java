package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "true_or_false_seq")
public class TrueOrFalse {

    /**
     */
    @NotNull
    @Size(max = 2048)
    private String question;

    /**
     */
    @NotNull
    private Boolean answer;

    /**
     */
    @NotNull
    @ManyToOne
    private Category category;
}
