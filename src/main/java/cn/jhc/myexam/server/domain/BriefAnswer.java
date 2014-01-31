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
@RooJpaEntity(sequenceName = "brief_answer_seq")
public class BriefAnswer {

    /**
     */
    @NotNull
    @Size(min = 5, max = 2048)
    @Description("题目")
    @ImportColumn
    private String question;

    /**
     */
    @Size(max = 2048)
    @Description("答案")
    @ImportColumn
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
    @Description("是否上传文件")
    private Boolean uploadFile = false;
}
