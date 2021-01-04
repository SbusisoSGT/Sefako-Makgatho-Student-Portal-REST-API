package org.sefako.makgatho.demo.models;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "modules")
public class Module {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	private String name;
	
	@Column(unique = true)
	private String code;
	private int year;
	private int academicPeriod;
	private boolean prerequisite;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
	@JsonBackReference
	private Set<CourseModule> courseModules = new HashSet<>();
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "module")
	@JsonBackReference
	private Set<StudentModule> studentModules = new HashSet<>();

	@ManyToMany(mappedBy = "modules")
	@JsonManagedReference
	private Set<Lecturer> lecturers = new HashSet<>();

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

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getAcademicPeriod() {
		return academicPeriod;
	}

	public void setAcademicPeriod(int academicPeriod) {
		this.academicPeriod = academicPeriod;
	}

	public boolean isPrerequisite() {
		return prerequisite;
	}

	public void setPrerequisite(boolean prerequisite) {
		this.prerequisite = prerequisite;
	}

	public Set<CourseModule> getCourseModules() {
		return courseModules;
	}

	public void setCourseModules(Set<CourseModule> courseModules) {
		this.courseModules = courseModules;
	}

	public Set<StudentModule> getStudentModules() {
		return studentModules;
	}

	public void setStudentModules(Set<StudentModule> studentModules) {
		this.studentModules = studentModules;
	}
}
