package org.sefako.makgatho.demo.services;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.Course;
import org.sefako.makgatho.demo.models.CourseModule;
import org.sefako.makgatho.demo.models.Module;
import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.models.StudentCourse;
import org.sefako.makgatho.demo.models.StudentModule;
import org.sefako.makgatho.demo.models.dto.StudentCourseDTO;
import org.sefako.makgatho.demo.repositories.CourseRepository;
import org.sefako.makgatho.demo.repositories.StudentCourseRepository;
import org.sefako.makgatho.demo.repositories.StudentModuleRepository;
import org.sefako.makgatho.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	
	@Autowired
	StudentModuleRepository studentModuleRepository;
	
	@Autowired
	StudentCourseRepository studentCourseRepository;
	
	public boolean exists(Integer id)
	{
		return studentCourseRepository.existsById(id);
	}
	
	public List<StudentCourse> all()
	{
		return studentCourseRepository.findAll();
	}
	
	public StudentCourse find(Integer id)
	{
		return studentCourseRepository.findById(id).get();
	}
	
	public void save(StudentCourseDTO studentCourseDTO)
	{
		Student student = studentRepository.findById(studentCourseDTO.getStudent_id()).get();
		Course course = courseRepository.findById(studentCourseDTO.getCourse_id()).get();
		
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setStudent(student);
		studentCourse.setCourse(course);
		studentCourse.setRegisteredAt(LocalDate.now());
		studentCourse.setCurrentLevel(1);
		studentCourse.setApproved(false);
		studentCourseRepository.save(studentCourse);
	}
	
	
	public void updateCompletedStatus(Integer student_course_id)
	{
		StudentCourse course = studentCourseRepository.findById(student_course_id).get();
		course.setCompleted(true);
		studentCourseRepository.save(course);
	}
	
	public void updateApplicationStatus(Integer student_course_id)
	{
		StudentCourse course = studentCourseRepository.findById(student_course_id).get();
		course.setApproved(true);
		studentCourseRepository.save(course);
		this.registerCompulsoryModules(course);
	}
	
	public void delete(Integer id) 
	{
		studentCourseRepository.deleteById(id);
	}
	
	public Set<StudentModule> studentCourseModules(Integer id)
	{
		return studentCourseRepository.findById(id).get().getStudentModules();
	}
	
	public StudentModule findStudentCourseModule(Integer course_id, Integer module_id)
	{
		
		StudentModule module = null;
		Set<StudentModule> modules = this.studentCourseModules(course_id);
		
		for(StudentModule thismodule: modules) {
			if(thismodule == module)
					module = thismodule;
		}
		return module;
	}
	
	public boolean completedUndergradCourse(StudentCourseDTO studentCourse)
	{
		
		boolean completedUndergradCourse = true;
		
//		Course course = courseRepository.findById(studentCourse.getCourse_id()).get();
//		Set<Department> courseDepartments = course.getSchool().getDepartments();
		
		//		Student student = studentRepository.findById(student_id).get();
//		boolean completedAllCourses = true;
//		Set<StudentCourse> courses = student.getStudentCourses();
//		
//		for(StudentCourse course : courses)
//		{
//			if(!course.isCompleted())
//				completedAllCourses = false;	
//		}
//		
		return completedUndergradCourse;
	}
	
	public void registerCompulsoryModules(StudentCourse studentCourse)
	{
		Set<CourseModule> courseModules = studentCourse.getCourse().getCourseModules();
		courseModules.removeIf(thiscourse -> (thiscourse.isCompulsory() == false));
		
		Set<Module> modules = new HashSet<Module>();
		courseModules.forEach(thiscourse -> {
			modules.add(thiscourse.getModule());
		});

		modules.removeIf(thismodule -> (
			thismodule.getYear() != studentCourse.getCurrentLevel()	
		));
		
		modules.forEach(thismodule -> {
			StudentModule studentModule = new StudentModule();
			studentModule.setCourse(studentCourse);
			studentModule.setModule(thismodule);
			studentModule.setRegisteredAt(LocalDate.now());
			studentModuleRepository.save(studentModule);
		});
	}
}
