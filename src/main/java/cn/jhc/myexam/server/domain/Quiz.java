package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "quiz_seq")
public class Quiz {

    /**
     */
    @NotNull
    @Size(max = 1024)
    private String name;

    /**
     */
    @Size(max = 2048)
    private String info;

    /**
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh::mm::ss")
    private Date timeOpen;

    /**
     */
    @Temporal(TemporalType.TIME)
    @DateTimeFormat(pattern = "yyyy-MM-dd hh::mm::ss")
    private Date timeClose;

    /**
     * The content format is like this:
     * SingleChoice:2,40|BriefAnswer:10,2
     * This content means this quiz should have 40 SingleChoice problems(2 points for each) and 2 BriefAnswer problems(10 points for each).
     */
    @Size(max = 1024)
    private String content;

    /**
     */
    @NotNull
    @ManyToOne
    private Category category;
}
