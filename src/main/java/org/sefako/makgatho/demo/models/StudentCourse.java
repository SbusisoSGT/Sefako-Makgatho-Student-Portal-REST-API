package org.sefako.makgatho.demo.models;

import java.util.Date;
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
	
	private Date registeredAt;
	
	@Column(columnDefinition = "boolean default false")
	private boolean completed;
	
	@Column(columnDefinition = "INT default 1")
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
	
	public Set<StudentModule> getCurrentYearModules()
	{
		Set<StudentModule> modules = this.getStudentModules();
		
		modules.removeIf(thismodule -> (thismodule.getModule().getYear() != this.getCurrentLevel()));		
		return modules;
	}
	
	public boolean completedYearModules()
	{
		boolean completedYearModules = true;

		Set<StudentModule> modules = this.getCurrentYearModules();
	
		for(StudentModule thismodule: modules)
		{
			if(thismodule.isCompleted() == false) {
				completedYearModules = false;
				break;
			}
		}
		
		return completedYearModules;
	}
	
	public boolean passedYearModules()
	{
		boolean passedYearModules = true;
		final int passGrade = 50;
		
		Set<StudentModule> modules = this.getCurrentYearModules();
		
		for(StudentModule thismodule: modules)
		{
			if(thismodule.getGrade() < passGrade) {
				passedYearModules = false;
				break;
			}
		}
		return passedYearModules;
	}
	
	public Set<StudentModule> getFailedModules()
	{
		final int passGrade = 50;
		
		Set<StudentModule> modules = this.getCurrentYearModules();
		modules.removeIf(thismodule -> (thismodule.getGrade() >= passGrade));
		
		return modules;
 	}
	
	public boolean failedCompulsoryModules()
	{
		boolean failedCompulsoryModules = false;
		Set<StudentModule> failedModules = this.getFailedModules();
		
		//Check if any of the failed module is compulsory
		for(StudentModule thismodule: failedModules)
		{
			Set<CourseModule> courseModules = thismodule.getModule().getCourseModules();
			//courseModules.removeIf(thiscourse -> ());
			
		}
		return failedCompulsoryModules;
	}
	
}
