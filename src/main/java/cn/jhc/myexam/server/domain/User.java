package cn.jhc.myexam.server.domain;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;

import cn.jhc.myexam.annotation.Description;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "user_seq")
public class User implements Serializable{

    private static final long serialVersionUID = 1L;

	/**
     */
    @NotNull
    @Column(unique = true)
    @Size(max = 64)
    @Description("用户名")
    private String username;

    /**
     */
    @NotNull
    @Size(max = 1024)
    private String password;

    /**
     */
    @NotNull
    @Column(columnDefinition="bit", length=1)
    @Description("是否启用")
    private Boolean enabled;

    /**
     */
    @Size(max = 128)
    @Description("姓名")
    private String displayName;

    /**
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Role> roles = new ArrayList<Role>();
}
