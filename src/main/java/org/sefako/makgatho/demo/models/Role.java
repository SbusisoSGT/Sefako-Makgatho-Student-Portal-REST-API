package org.sefako.makgatho.demo.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Role {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	private String name;
	

	@ManyToMany()
	@JoinTable(name="role_permissions", 
		joinColumns = { @JoinColumn(name="role_id")},
		inverseJoinColumns = {@JoinColumn(name="permission_id")}	
	)
	private Set<Permission> permissions;
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToMany()
	@JoinTable(name="role_users", 
		joinColumns = { @JoinColumn(name="role_id")},
		inverseJoinColumns = {@JoinColumn(name="user_id")}	
	)
	private Set<User> users;
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getId() {
		return id;
	}

	public Set<Permission> getPermissions() {
		return permissions;
	}

	public void setPermissions(Set<Permission> permissions) {
		this.permissions = permissions;
	}
}
