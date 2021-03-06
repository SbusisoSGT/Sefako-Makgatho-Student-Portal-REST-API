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
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "students")
public class Student{

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	@Column(unique = true)
	private Long studentNum;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	@JsonManagedReference
	private User user;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "student")
	@JsonBackReference
	private Set<StudentCourse> studentCourses = new HashSet<>();
	
	private LocalDate registeredAt;
	
	
	public LocalDate getRegisteredAt() {
		return registeredAt;
	}

	public void setRegisteredAt(LocalDate registeredAt) {
		this.registeredAt = registeredAt;
	}

	public Long getStudentNum() {
		return studentNum;
	}

	public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}

	public void setStudentNum(Long studentNum) {
		this.studentNum = studentNum;
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

	public Integer getId() {
		return id;
	}
}
