package org.sefako.makgatho.demo.services;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.models.StudentCourse;
import org.sefako.makgatho.demo.models.StudentModule;
import org.sefako.makgatho.demo.models.dto.StudentModuleDTO;
import org.sefako.makgatho.demo.models.dto.StudentModuleGradeDTO;
import org.sefako.makgatho.demo.repositories.ModuleRepository;
import org.sefako.makgatho.demo.repositories.StudentCourseRepository;
import org.sefako.makgatho.demo.repositories.StudentModuleRepository;
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
	StudentCourseService studentCourseService;
	
	@Autowired
	StudentService studentService;
	
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
		module.setRegisteredAt(LocalDate.now());
		module.setAcademic_year(LocalDate.now().getYear());
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
	
	public void registerNextLevelModules(Integer module_id)
	{
		
		StudentCourse studentCourse = this.getStudentCourse(module_id);
		Student student = studentCourse.getStudent();
		
		if(studentService.completedYearModules(student.getId())) {
	
			studentService.passedCurrentYearModules(student.getId());
			
			if(studentService.passedCurrentYearModules(student.getId())) {
				this.updateCurrentYear(studentCourse);
				studentCourseService.registerCompulsoryModules(studentCourse);
				
			}else {
				Set<StudentModule> failedModules = studentService.getFailedModules(student.getId());
				if(!failedModules.isEmpty()) {
					 //If the student didn't fail any compulsory module
					if(studentService.getFailedCompulsoryModules(student.getId()).isEmpty())
						this.updateCurrentYear(studentCourse); //Upgrade to the next year
					
					this.registerNextYearFailedModules(failedModules, studentCourse);
				}
			}		
		}
	}
	
	public void registerNextYearFailedModules(Set<StudentModule> failedModules, StudentCourse studentCourse)
	{
		for(StudentModule thismodule: failedModules)
		{
			StudentModule studentModule = new StudentModule();
			studentModule.setCourse(studentCourse);
			studentModule.setModule(thismodule.getModule());
			studentModule.setAcademic_year(thismodule.getAcademic_year() + 1); //set the academic year as the next year
			studentModule.setRegisteredAt(LocalDate.now());
			studentModuleRepository.save(studentModule);
		}
	}
	
	public StudentCourse getStudentCourse(Integer module_id)
	{
		return studentModuleRepository.findById(module_id).get().getCourse();
	}
	
	public void delete(Integer id)
	{
		studentModuleRepository.deleteById(id);
	}
}
