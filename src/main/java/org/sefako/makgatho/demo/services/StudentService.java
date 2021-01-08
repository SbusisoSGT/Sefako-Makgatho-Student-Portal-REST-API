package org.sefako.makgatho.demo.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.Role;
import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.models.StudentCourse;
import org.sefako.makgatho.demo.models.StudentModule;
import org.sefako.makgatho.demo.models.User;
import org.sefako.makgatho.demo.models.dto.StudentDTO;
import org.sefako.makgatho.demo.repositories.RoleRepository;
import org.sefako.makgatho.demo.repositories.StudentCourseRepository;
import org.sefako.makgatho.demo.repositories.StudentRepository;
import org.sefako.makgatho.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentCourseRepository studentCourseRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public boolean exists(Integer id)
	{
		return studentRepository.existsById(id);
	}
	
	public List<Student> all()
	{
		return studentRepository.findAll();
	}
	
	public Student find(Integer id)
	{
		return studentRepository.findById(id).get();
	}
	
	public boolean save(StudentDTO studentDTO)
	{
		if(roleRepository.existsById(studentDTO.getRole_id())) {
			User user  = new User();
			user.setFirstname(studentDTO.getFirstname());
			user.setLastname(studentDTO.getLastname());
			user.setEmail(studentDTO.getEmail());
			user.setPassword(studentDTO.getPassword());
			
			Role role = roleRepository.findById(studentDTO.getRole_id()).get();
			Set<Role> roles = new HashSet<Role>();
			roles.add(role);
			
			user.setRoles(roles);
			userRepository.save(user);
			
			Student student = new Student();
			student.setStudentNum(studentDTO.getStudentNum());
			student.setRegisteredAt(new Date());
			student.setUser(user);
			studentRepository.save(student);
			
			return true;
		}else
			return false;
	}
	
	public void update(StudentDTO StudentDTO)
	{
		//
	}
	
	public Set<StudentCourse> studentCourses(Integer id)
	{
		return studentRepository.findById(id).get().getStudentCourses();
	}
	
	public Set<StudentModule> studentCourseModules(Integer student_course_id)
	{
		return studentCourseRepository.findById(student_course_id).get().getStudentModules();
	}
	
	public boolean completedAllCourses(Integer student_id)
	{
		boolean completedAllCourses = true;
		Set<StudentCourse> courses = this.find(student_id).getStudentCourses();
		
		for(StudentCourse course : courses)
		{
			if(!course.isCompleted())
				completedAllCourses = false;	
		}
		
		return completedAllCourses;
	}
	
	public StudentCourse getStudentCurrentCourse(Integer student_id)
	{
		StudentCourse completedCourse = null;
		
		if(this.find(student_id).getStudentCourses().size() > 0)
			completedCourse = (StudentCourse) this.find(student_id).getStudentCourses().toArray()[this.find(student_id).getStudentCourses().size() - 1];
		
		return completedCourse;
	}
	
	public boolean passedCurrentYearModules(Integer student_id)
	{
		boolean passedYearModules = true;
		final int passGrade = 50;
	
		Set<StudentModule> modules = this.getStudentCurrentYearModules(student_id);
		
		for(StudentModule thismodule: modules)
		{
			if(thismodule.getGrade() < passGrade) {
				passedYearModules = false;
				break;
			}
		}
		return passedYearModules;
	}
	
	public boolean passedPreviousCourse()
	{
		boolean passedPreviousCourse = false;
		
		//
		
		return passedPreviousCourse;
	}
	
	public boolean qualifiesForPostgrad(Integer student_id)
	{
		boolean qualifiesForPostgrad = false;
		
		StudentCourse currentCourse = this.getStudentCurrentCourse(student_id);
		if(currentCourse != null) {
			Set<StudentModule> studentModules = currentCourse.getStudentModules();
			int sum = 0;
			double average = 0.0;
			
			for(StudentModule module: studentModules)
				sum += module.getGrade();
			
			average = sum / studentModules.size();
			
			if(average >=  60.0)
				qualifiesForPostgrad = true;
		}
		
		return qualifiesForPostgrad;
	}
	
	public Set<StudentModule> getStudentCurrentYearModules(Integer student_id)
	{
		StudentCourse currentCourse = this.getStudentCurrentCourse(student_id);
		Set<StudentModule> modules = currentCourse.getStudentModules();
		
		modules.removeIf(thismodule -> (thismodule.getModule().getYear() != currentCourse.getCurrentLevel()));		
		return modules;
	}
	
	public boolean completedYearModules(Integer student_id)
	{
		boolean completedYearModules = true;

		Set<StudentModule> modules = this.getStudentCurrentYearModules(student_id);
	
		for(StudentModule thismodule: modules)
		{
			if(thismodule.isCompleted() == false) {
				completedYearModules = false;
				break;
			}
		}
		
		return completedYearModules;
	}
	
//	@Transient
//	public boolean failedCompulsoryModules()
//	{
//		boolean failedCompulsoryModules = false;
//		Set<StudentModule> failedModules = this.getFailedModules();
//		
//		//Check if any of the failed module is compulsory
//		for(StudentModule thismodule: failedModules)
//		{
//			Set<CourseModule> courseModules = thismodule.getModule().getCourseModules();
//			//courseModules.removeIf(thiscourse -> ());
//			
//		}
//		return failedCompulsoryModules;
//	}
	
//	@Transient
//	public Set<StudentModule> getFailedModules()
//	{
//		final int passGrade = 50;
//		
//		Set<StudentModule> modules = this.getCurrentYearModules();
//		modules.removeIf(thismodule -> (thismodule.getGrade() >= passGrade));
//		
//		return modules;
// 	}
}




