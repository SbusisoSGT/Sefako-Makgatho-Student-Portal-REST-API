package org.sefako.makgatho.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.CourseModule;
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
	
	public void save(StudentDTO studentDTO)
	{
		User user  = new User();
		user.setFirstname(studentDTO.getFirstname());
		user.setLastname(studentDTO.getLastname());
		user.setEmail(studentDTO.getEmail());
		user.setPassword(studentDTO.getPassword());

		Role role = roleRepository.findById(studentDTO.getRole_id()).get();

		user.getRoles().add(role);
		userRepository.save(user);

		Student student = new Student();
		student.setStudentNum(studentDTO.getStudentNum());
		student.setRegisteredAt(LocalDate.now());
		student.setUser(user);
		studentRepository.save(student);
	}
	
	public void update(Student student)
	{
		studentRepository.save(student);
	}
	
	public Set<StudentCourse> studentCourses(Integer id)
	{
		return studentRepository.findById(id).get().getStudentCourses();
	}
	
	public Set<StudentModule> studentCourseModules(Integer student_id, Integer student_course_id)
	{
		StudentCourse studentCourse = null;
		Set<StudentModule> studentModules = null;
		Set<StudentCourse> courses = this.find(student_id).getStudentCourses();
		
		for(StudentCourse thiscourse: courses) {
			if(thiscourse.getId() == student_course_id)
				studentCourse = thiscourse;
		}
		
		if(studentCourse != null) {
			studentModules = studentCourse.getStudentModules();
		}
		
		return studentModules;
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
	
	public Set<StudentModule> getFailedCompulsoryModules(Integer student_id)
	{
		Set<StudentModule> failedModules = this.getFailedModules(student_id);
		
		//Check if any of the failed module is compulsory
		for(StudentModule thisStudentModule: failedModules)
		{
			Set<CourseModule> courseModules = thisStudentModule.getModule().getCourseModules();
			
			for(CourseModule courseModule: courseModules) {
				if(courseModule.getModule() == thisStudentModule.getModule()) {
					if(!courseModule.isCompulsory())
						failedModules.remove(thisStudentModule);
				}
					
			}
		}
		return failedModules;
	}
	
	public Set<StudentModule> getFailedModules(Integer student_id)
	{
		final int passGrade = 50;
		
		Set<StudentModule> modules = this.getStudentCurrentYearModules(student_id);
		modules.removeIf(thismodule -> (thismodule.getGrade() >= passGrade));
		
		return modules;
 	}
}




