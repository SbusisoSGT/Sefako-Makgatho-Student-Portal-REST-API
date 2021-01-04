package org.sefako.makgatho.demo.models;

import java.util.HashSet;
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

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "lecturers")
public class Lecturer{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToMany()
	@JoinTable(name="lecturer_modules", 
		joinColumns = { @JoinColumn(name="lecturer_id")},
		inverseJoinColumns = {@JoinColumn(name="module_id")}	
	)
	@JsonBackReference
	private Set<Module> modules = new HashSet<>();
	
	@ManyToMany()
	@JoinTable(name="lecturer_courses", 
		joinColumns = { @JoinColumn(name="lecturer_id")},
		inverseJoinColumns = {@JoinColumn(name="course_id")}	
	)
	@JsonBackReference
	private Set<Course> courses = new HashSet<>();
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;
	
	public Integer getId() {
		return id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public void setId(Integer id) {
		this.id = id;
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
