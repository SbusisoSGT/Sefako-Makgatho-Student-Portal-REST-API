package org.sefako.makgatho.demo.models;

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
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "courses")
public class Course {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@Column(unique = true)
	private String code;
	private int duration;
	private int capacity;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "qualification_id")
	@JsonManagedReference
	private Qualification qualification;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "school_id")
	@JsonManagedReference
	private School school;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	@JsonBackReference
	private Set<CourseModule> courseModules = new HashSet<>();

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "course")
	@JsonBackReference
	private Set<StudentCourse> studentCourses = new HashSet<>();
	
	@ManyToMany(mappedBy = "courses")
	@JsonBackReference
	private Set<Lecturer> lecturers = new HashSet<>();

	public Set<CourseModule> getCourseModules() {
		return courseModules;
	}

	public void setCourseModules(Set<CourseModule> courseModules) {
		this.courseModules = courseModules;
	}
	
	public Set<Lecturer> getLecturers() {
		return lecturers;
	}

	public void setLecturers(Set<Lecturer> lecturers) {
		this.lecturers = lecturers;
	}

	public Integer getId() {
		return id;
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

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public Qualification getQualification() {
		return qualification;
	}

	public void setQualification(Qualification qualification) {
		this.qualification = qualification;
	}

	public School getSchool() {
		return school;
	}

	public void setSchool(School school) {
		this.school = school;
	}

	public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}

	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
	
	public boolean isPostGraduateCourse()
	{
		if(this.qualification.getId() == 1 || this.qualification.getId() == 2)
			return false;
			
		return true;
	}
	
	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
}
