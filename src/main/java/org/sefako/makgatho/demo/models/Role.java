package org.sefako.makgatho.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

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
	@JsonBackReference
	private Set<Permission> permissions = new HashSet<>();
	
	@ManyToMany()
	@JoinTable(name="role_users", 
		joinColumns = { @JoinColumn(name="role_id")},
		inverseJoinColumns = {@JoinColumn(name="user_id")}	
	)
	@JsonBackReference
	private Set<User> users = new HashSet<>();
	
	
	public Set<User> getUsers() {
		return users;
	}

	public void setUsers(Set<User> users) {
		this.users = users;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
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
