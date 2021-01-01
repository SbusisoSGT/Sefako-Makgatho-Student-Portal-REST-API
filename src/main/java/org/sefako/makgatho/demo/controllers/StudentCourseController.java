package org.sefako.makgatho.demo.controllers;

import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.models.StudentCourse;
import org.sefako.makgatho.demo.models.StudentModule;
import org.sefako.makgatho.demo.models.dto.StudentCourseDTO;
import org.sefako.makgatho.demo.repositories.CourseRepository;
import org.sefako.makgatho.demo.repositories.StudentCourseRepository;
import org.sefako.makgatho.demo.repositories.StudentRepository;
import org.sefako.makgatho.demo.services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/students/courses/")
public class StudentCourseController {
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	StudentCourseRepository studentCourseRepository;
	
	@Autowired
	StudentCourseService studentCourseService;
	
	@GetMapping("/")
	public List<StudentCourse> index()
	{
		return studentCourseService.all();
	}
	
	@GetMapping("/{id}")
	public StudentCourse show(@PathVariable Integer id)
	{
		return studentCourseService.find(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> store(@RequestBody StudentCourseDTO studentCourseDTO)
	{
		if(studentRepository.existsById(studentCourseDTO.getStudent_id()) && courseRepository.existsById(studentCourseDTO.getCourse_id()))
		{
			if(this.completedAllCourses(studentCourseDTO.getStudent_id()))
			{
				if(passedPreviousCourse(studentCourseDTO.getStudent_id()))
				{
					studentCourseService.save(studentCourseDTO);
					return new ResponseEntity<>("Student failed to obtain average of 60% in previous grade assessments", HttpStatus.FORBIDDEN);
					
				}else {
					return new ResponseEntity<>("Student must complete their current course before registering new one", HttpStatus.FORBIDDEN);
				}
					
			}else {
				return new ResponseEntity<>("Student must complete their current course before registering new one", HttpStatus.FORBIDDEN);
			}
			
		}else
			return new ResponseEntity<>("Student or Course Not Found", HttpStatus.NOT_FOUND);
	}
	
	private boolean passedPreviousCourse(Integer student_id)
	{
		boolean passedPreviousCourse = false;
		
		Student student = studentRepository.findById(student_id).get();
		
		StudentCourse completedCourse = (StudentCourse) student.getStudentCourses().toArray()[student.getStudentCourses().size() - 1];
		Set<StudentModule> studentModules = completedCourse.getStudentModules();
		int sum = 0;
		double average = 0.0;
		
		for(StudentModule module: studentModules)
			sum += module.getGrade();
		
		average = sum / studentModules.size();
		
		if(average >=  60.0)
			passedPreviousCourse = true;
		
		return passedPreviousCourse;
	}
	
	private boolean completedAllCourses(Integer student_id)
	{
		Student student = studentRepository.findById(student_id).get();
		boolean completedAllCourses = true;
		Set<StudentCourse> courses = student.getStudentCourses();
		
		for(StudentCourse course : courses)
		{
			if(!course.isCompleted())
				completedAllCourses = false;	
		}
		
		return completedAllCourses;
	}
}
