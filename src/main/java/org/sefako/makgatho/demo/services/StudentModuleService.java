package org.sefako.makgatho.demo.services;

import java.util.Date;
import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.StudentCourse;
import org.sefako.makgatho.demo.models.StudentModule;
import org.sefako.makgatho.demo.models.dto.StudentModuleDTO;
import org.sefako.makgatho.demo.models.dto.StudentModuleGradeDTO;
import org.sefako.makgatho.demo.repositories.ModuleRepository;
import org.sefako.makgatho.demo.repositories.StudentCourseRepository;
import org.sefako.makgatho.demo.repositories.StudentModuleRepository;
import org.sefako.makgatho.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentModuleService {

	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	StudentModuleRepository studentModuleRepository;
	
	@Autowired
	StudentCourseRepository studentCourseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	public List<StudentModule> all()
	{
		return studentModuleRepository.findAll();
	}
	
	public StudentModule find(Integer id)
	{
		return studentModuleRepository.findById(id).get();
	}
	
	public boolean exists(Integer id)
	{
		return studentModuleRepository.existsById(id);
	}
	
	public void save(StudentModuleDTO studentModuleDTO)
	{
		StudentModule module = new StudentModule();
		module.setCourse(studentCourseRepository.findById(studentModuleDTO.getStudent_course_id()).get());
		module.setModule(moduleRepository.findById(studentModuleDTO.getModule_id()).get());
		module.setRegisteredAt(new Date());
		
		studentModuleRepository.save(module);
	}
	
	public void updateModuleGrade(Integer id, StudentModuleGradeDTO gradeDTO)
	{
		StudentModule module = studentModuleRepository.findById(id).get();
		module.setGrade(gradeDTO.getGrade());
		module.setCompleted(true);
		studentModuleRepository.save(module);
	}
	
	public void updateCurrentYear(StudentCourse course)
	{			
		if(course.getCurrentLevel() == course.getCourse().getDuration())
			course.setCompleted(true);
		else
			course.setCurrentLevel(course.getCurrentLevel() + 1);
		studentCourseRepository.save(course);
	}
	
//	public void s(Integer module_id)
//	{
//		StudentCourse course = this.getStudentCourse(module_id);
//		if(course.passedYearModules()) {
//			this.updateCurrentYear(course);
//			
//		}else {
//			Set<StudentModule> failedModules = course.getFailedModules();
//			
//		}
//			
//	}
	
	public StudentCourse getStudentCourse(Integer module_id)
	{
		return studentModuleRepository.findById(module_id).get().getCourse();
	}
	
	public void delete(Integer id)
	{
		studentModuleRepository.deleteById(id);
	}
}
