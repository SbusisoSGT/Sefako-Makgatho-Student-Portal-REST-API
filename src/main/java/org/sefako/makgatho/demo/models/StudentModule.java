package org.sefako.makgatho.demo.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_modules")
public class StudentModule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(columnDefinition = "boolean default false")
	private boolean completed;
	
	private int grade;
	
	private Date registeredAt;
	
	@ManyToOne
	@JoinColumn(name = "student_course_id")
	private StudentCourse course;
	
	@ManyToOne
	@JoinColumn(name = "module_id")
	private Module module;
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public StudentCourse getCourse() {
		return course;
	}

	public void setCourse(StudentCourse course) {
		this.course = course;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
		this.registeredAt = registeredAt;
	}
}
