package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "brief_answer_seq")
public class BriefAnswer {

    /**
     */
    @NotNull
    @Size(min = 5, max = 2048)
    private String question;

    /**
     */
    @Size(max = 2048)
    private String answer;

    /**
     */
    @NotNull
    @ManyToOne
    private Category category;

    /**
     * donate that the answer is an uploaded file.
     */
    @Column(columnDefinition="BIT", length=1)
    private Boolean uploadFile;
}
