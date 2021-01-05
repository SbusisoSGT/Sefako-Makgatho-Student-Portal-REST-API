package org.sefako.makgatho.demo.services;

import java.util.Date;
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
		studentCourse.setRegisteredAt(new Date());
		studentCourse.setCurrentLevel(1);
		studentCourseRepository.save(studentCourse);
		
		this.registerCompulsoryModules(studentCourse);
	}
	
	public void updateCourseLevel(Integer id, StudentCourse studentCourse)
	{
		
	}
	
	public void delete(Integer id) 
	{
		studentCourseRepository.deleteById(id);
	}
	
	public Set<StudentModule> studentCourseModules(Integer id)
	{
		return studentCourseRepository.findById(id).get().getStudentModules();
	}
	
	private void registerCompulsoryModules(StudentCourse studentCourse)
	{
		Set<CourseModule> courseModules = studentCourse.getCourse().getCourseModules();
		courseModules.removeIf(thiscourse -> (thiscourse.isCompulsory() == false));
		
		Set<Module> modules = new HashSet<Module>();
		courseModules.forEach(thiscourse -> {
			modules.add(thiscourse.getModule());
		});

		modules.removeIf(thismodule -> (
			thismodule.getYear() != 1	
		));
		
		modules.forEach(thismodule -> {
			StudentModule studentModule = new StudentModule();
			studentModule.setCourse(studentCourse);
			studentModule.setModule(thismodule);
			studentModule.setRegisteredAt(new Date());
			studentModuleRepository.save(studentModule);
		});
	}
}
