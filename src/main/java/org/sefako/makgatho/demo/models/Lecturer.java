package org.sefako.makgatho.demo.models;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "lecturers")
public class Lecturer extends User{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne()
	@JoinColumn(name = "role_id")
	private Role role;
	
	@ManyToMany()
	@JoinTable(name="lecturer_modules", 
		joinColumns = { @JoinColumn(name="lecturer_id")},
		inverseJoinColumns = {@JoinColumn(name="module_id")}	
	)
	private Set<Module> modules;
	
	@ManyToMany()
	@JoinTable(name="lecturer_courses", 
		joinColumns = { @JoinColumn(name="lecturer_id")},
		inverseJoinColumns = {@JoinColumn(name="course_id")}	
	)
	private Set<Course> courses;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Set<Module> getModules() {
		return modules;
	}

	public void setModules(Set<Module> modules) {
		this.modules = modules;
	}

	public Set<Course> getCourses() {
		return courses;
	}

	public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}
}
