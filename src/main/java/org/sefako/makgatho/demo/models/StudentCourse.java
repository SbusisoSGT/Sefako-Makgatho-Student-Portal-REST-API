package org.sefako.makgatho.demo.models;

import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "student_courses")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "student_id")
	private Student student;
	
	@ManyToOne
	@JoinColumn(name = "course_id")
	private Course course;
	
	@ManyToMany(mappedBy = "module")
	private Set<StudentModule> studentModules;
	
	private Date registeredAt;
	
	@Column(columnDefinition = "boolean default false")
	private boolean completed;
	
	private int currentLevel;

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

	public Date getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(Date registeredAt) {
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
