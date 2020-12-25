package org.sefako.makgatho.demo.models;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "students")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(unique = true)
	private Long studentNum;
	
	@ManyToOne()
	@JoinColumn(name = "user_id")
	private User user;
	
	@ManyToOne()
	@JoinColumn(name = "role_id")
	private Role role;

	@OneToMany(mappedBy = "student")
	private Set<StudentCourse> studentCourses;
	
	public Long getStudentNum() {
		return studentNum;
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

	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public Integer getId() {
		return id;
	}
	
}
