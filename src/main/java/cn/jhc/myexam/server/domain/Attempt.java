package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import cn.jhc.myexam.shared.domain.QuestionType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "attempt_seq")
public class Attempt {

    /**
     */
    @NotNull
    @Enumerated
    private QuestionType questionType;

    /**
     */
    @Size(max = 2048)
    private String answer;

    /**
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh::mm::ss")
    private Date submitDate;

    /**
     */
    @ManyToOne
    private User user;

    /**
     */
    @ManyToOne
    private Quiz quiz;

    /**
     */
    @NotNull
    private Long questionId;
}
