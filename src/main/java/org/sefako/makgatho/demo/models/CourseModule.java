package org.sefako.makgatho.demo.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "course_modules")
public class CourseModule {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	@JsonManagedReference
	private Course course;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "module_id")
	@JsonManagedReference
	private Module module;
	
	@Column(columnDefinition = "boolean default false")
	private boolean compulsory;
	
	public boolean isCompulsory() {
		return compulsory;
	}

	public void setCompulsory(boolean compulsory) {
		this.compulsory = compulsory;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
}
