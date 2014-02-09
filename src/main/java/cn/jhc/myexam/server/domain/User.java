package cn.jhc.myexam.server.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import org.springframework.roo.addon.javabean.RooJavaBean;
import org.springframework.roo.addon.jpa.entity.RooJpaEntity;
import org.springframework.roo.addon.tostring.RooToString;
import cn.jhc.myexam.annotation.Description;
import cn.jhc.myexam.annotation.ImportColumn;
import javax.validation.constraints.Pattern;

@RooJavaBean
@RooToString
@RooJpaEntity(sequenceName = "user_seq")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
     */
	@NotNull
	@Column(unique = true)
	@Size(max = 64)
	@Description("登陆名")
	@ImportColumn
	private String username;

	/**
     */
	@NotNull
	@Size(max = 1024)
	@Description("密码")
	@ImportColumn
	private String password;

	/**
     */
	@NotNull
	@Column(columnDefinition = "bit", length = 1)
	@Description("是否启用")
	private Boolean enabled = true;

	/**
     */
	@Size(max = 128)
	@Description("用户名")
	@ImportColumn
	private String displayName;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", 
		joinColumns = @javax.persistence.JoinColumn(name = "user_id"), 
		inverseJoinColumns = @javax.persistence.JoinColumn(name = "role_id"))
	private List<Role> roles = new ArrayList<Role>();

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_category", 
		joinColumns = @javax.persistence.JoinColumn(name = "user_id"), 
		inverseJoinColumns = @javax.persistence.JoinColumn(name = "category_id"))
	private Set<Category> categories = new HashSet<Category>();

	/**
     */
	@Size(min = 6, max = 128)
	@Pattern(regexp = "^[0-9a-zA-Z]([-.\\w]*[0-9a-zA-Z_+])*@([0-9a-zA-Z][-\\w]*[0-9a-zA-Z]\\.)+[a-zA-Z]{2,9}$")
	private String email;
}
