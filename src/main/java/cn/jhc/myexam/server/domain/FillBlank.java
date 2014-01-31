package cn.jhc.myexam.server.domain;
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
@RooJpaEntity(sequenceName = "fill_blank_seq")
public class FillBlank {

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
    @Description("填空数量")
    @ImportColumn
    private Integer quantity;

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
}
