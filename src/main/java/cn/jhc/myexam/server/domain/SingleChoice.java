package cn.jhc.myexam.server.domain;
import java.io.Serializable;

import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import cn.jhc.myexam.annotation.Description;
import cn.jhc.myexam.annotation.ImportColumn;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.persistence.ManyToOne;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "single_choice_seq")
public class SingleChoice implements Serializable{

    private static final long serialVersionUID = 1L;

	/**
     */
    @NotNull
    @Size(max = 2048)
    @Description("题目")
    @ImportColumn
    private String question;

    /**
     */
    @Size(max = 2048)
    @Description("选项A")
    @ImportColumn
    private String optionA;

    /**
     */
    @Size(max = 2048)
    @Description("选项B")
    @ImportColumn
    private String optionB;

    /**
     */
    @Size(max = 2048)
    @Description("选项C")
    @ImportColumn
    private String optionC;

    /**
     */
    @Size(max = 2048)
    @Description("选项D")
    @ImportColumn
    private String optionD;

    /**
     */
    @NotNull
    @Size(min = 1, max = 1)
    @Description("答案")
    @ImportColumn
    private String answer;

    /**
     */
    @NotNull
    @ManyToOne
    private Category category;
}
