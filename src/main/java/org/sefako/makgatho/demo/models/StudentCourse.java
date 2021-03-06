package org.sefako.makgatho.demo.models;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "student_courses")
public class StudentCourse{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "student_id")
	@JsonManagedReference
	private Student student;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "course_id")
	@JsonManagedReference
	private Course course;
	
	@ManyToMany(mappedBy = "course")
	@JsonBackReference
	private Set<StudentModule> studentModules = new HashSet<>();
	
	private LocalDate registeredAt;
	
	@Column(columnDefinition = "boolean default false")
	private boolean completed;
	
	@Column(columnDefinition = "INT default 1")
	private int currentLevel;
	
	@Column(columnDefinition = "boolean default false")
	private boolean approved;
	
	public boolean isApproved() {
		return approved;
	}

	public void setApproved(boolean approved) {
		this.approved = approved;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}

	public Set<StudentModule> getStudentModules() {
		return studentModules;
	}

	public void setStudentModules(Set<StudentModule> studentModules) {
		this.studentModules = studentModules;
	}

	public LocalDate getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDate registeredAt) {
		this.registeredAt = registeredAt;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	public int getCurrentLevel() {
		return currentLevel;
	}

	public void setCurrentLevel(int currentLevel) {
		this.currentLevel = currentLevel;
	}
}
