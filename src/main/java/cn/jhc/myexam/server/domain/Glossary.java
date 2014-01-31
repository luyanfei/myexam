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
@RooJpaEntity(sequenceName = "glossary_seq")
public class Glossary {

    /**
     */
    @NotNull
    @Size(max = 128)
    @Description("术语")
    @ImportColumn
    private String term;

    /**
     */
    @Size(max = 2048)
    @Description("释义")
    @ImportColumn
    private String defination;

    /**
     */
    @NotNull
    @ManyToOne
    private Category category;
}
