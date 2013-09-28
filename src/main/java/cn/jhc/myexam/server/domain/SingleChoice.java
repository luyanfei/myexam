package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "single_choice_seq")
public class SingleChoice {

    /**
     */
    @NotNull
    @Size(max = 2048)
    private String question;

    /**
     */
    @Size(max = 2048)
    private String optionA;

    /**
     */
    @Size(max = 2048)
    private String optionB;

    /**
     */
    @Size(max = 2048)
    private String optionC;

    /**
     */
    @Size(max = 2048)
    private String optionD;

    /**
     */
    @NotNull
    @Size(min = 1, max = 1)
    private String answer;

    /**
     */
    @NotNull
    @ManyToOne
    private Category category;
}
