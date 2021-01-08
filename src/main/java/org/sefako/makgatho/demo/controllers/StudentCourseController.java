package org.sefako.makgatho.demo.controllers;

import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.Course;
import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.models.StudentCourse;
import org.sefako.makgatho.demo.models.StudentModule;
import org.sefako.makgatho.demo.models.dto.StudentCourseDTO;
import org.sefako.makgatho.demo.repositories.CourseRepository;
import org.sefako.makgatho.demo.repositories.StudentCourseRepository;
import org.sefako.makgatho.demo.services.StudentCourseService;
import org.sefako.makgatho.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	StudentCourseRepository studentCourseRepository;
	
	@Autowired
	StudentCourseService studentCourseService;
	
	@Autowired
	StudentService studentService;
	
	@GetMapping
	public List<StudentCourse> index()
	{
		return studentCourseService.all();
	}
	
	@GetMapping("/{id}")
	public StudentCourse show(@PathVariable Integer id)
	{
		return studentCourseService.find(id);
	}
	
	@PostMapping("/postgraduate/")
	public ResponseEntity<?> registerPostgrad(@RequestBody StudentCourseDTO studentCourseDTO)
	{
		if(studentService.exists(studentCourseDTO.getStudent_id()) && courseRepository.existsById(studentCourseDTO.getCourse_id()))
		{
			Student student = studentService.find(studentCourseDTO.getStudent_id());
			Course course = courseRepository.findById(studentCourseDTO.getCourse_id()).get();
			
			String errorResponse = "";
			
			if(course.isPostGraduateCourse()) {	
				if(studentService.completedAllCourses(student.getId()))
				{
					if(studentService.qualifiesForPostgrad(student.getId()))
					{
						studentCourseService.save(studentCourseDTO);
						return new ResponseEntity<>("Student postgraduate course registered!", HttpStatus.CREATED);
						
					}else {
						errorResponse = "Student failed to obtain average of 60% in previous course!";
					}
						
				}else {
					errorResponse = "Student must complete their current course before registering new one!";
				}
			}else {
				errorResponse = "Course must be a postgraduate course!!";
			}
				
			return new ResponseEntity<>(errorResponse, HttpStatus.FORBIDDEN);
		}else
			return new ResponseEntity<>("Student or Course Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/undergraduate/")
	public ResponseEntity<?> registerUndergrad(@RequestBody StudentCourseDTO studentCourseDTO)
	{
		if(studentService.exists(studentCourseDTO.getStudent_id()) && courseRepository.existsById(studentCourseDTO.getCourse_id()))
		{
			studentCourseService.save(studentCourseDTO);
			return new ResponseEntity<>("Student undergraduate course registered!", HttpStatus.CREATED);
			
		}else
			return new ResponseEntity<>("Student or Course Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/{id}/approve-application/")
	public ResponseEntity<?> updateApplicationStatus(@PathVariable Integer id)
	{
		studentCourseService.updateApplicationStatus(id);
		
		return new ResponseEntity<>("Postgraduate application status updated! Application Approved.", HttpStatus.OK);
	}
	
	@PostMapping("/{id}/completed")
	public ResponseEntity<?> courseCompleted(@PathVariable Integer id)
	{
		studentCourseService.updateCompletedStatus(id);
		
		return new ResponseEntity<>("Student course completed status updated.", HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id)
	{
		if(studentCourseService.exists(id))
		{
			studentCourseService.delete(id);
			return new ResponseEntity<>("Student course deleted", HttpStatus.OK);
		}else
			return new ResponseEntity<>("Student course not found!", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{id}/modules")
	public Set<StudentModule> allStudentCourseModules(@PathVariable Integer id)
	{
		return studentCourseService.studentCourseModules(id);
	}
}
