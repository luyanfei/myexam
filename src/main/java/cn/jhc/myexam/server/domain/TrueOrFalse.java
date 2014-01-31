package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import cn.jhc.myexam.annotation.Description;
import cn.jhc.myexam.annotation.ImportColumn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.Column;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "true_or_false_seq")
public class TrueOrFalse {

    /**
     */
    @NotNull
    @Size(max = 2048)
    @Description("题目")
    @ImportColumn
    private String question;

    /**
     */
    @NotNull
    @Column(columnDefinition="bit", length=1)
    @Description("答案")
    @ImportColumn
    private Boolean answer;

    /**
     */
    @NotNull
    @ManyToOne
    private Category category;
}
