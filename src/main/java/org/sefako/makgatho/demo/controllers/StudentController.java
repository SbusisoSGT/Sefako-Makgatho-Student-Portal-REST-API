package org.sefako.makgatho.demo.controllers;

import java.util.List;

import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.models.dto.StudentDTO;
import org.sefako.makgatho.demo.repositories.RoleRepository;
import org.sefako.makgatho.demo.services.StudentCourseService;
import org.sefako.makgatho.demo.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController{

	@Autowired
	StudentService studentService;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	StudentCourseService studentCourseService;
	
	@GetMapping
	public List<Student> index()
	{
		return studentService.all();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id)
	{
		if(studentService.exists(id))
			return new ResponseEntity<>(studentService.find(id), HttpStatus.OK);
		else
			return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> store(@RequestBody StudentDTO studentDTO)
	{
		if(roleRepository.existsById(studentDTO.getRole_id())) {
			studentService.save(studentDTO);
			return new ResponseEntity<>("Student registered successfully", HttpStatus.CREATED);
		}else
			return new ResponseEntity<>("Role Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Student student)
	{
		if(studentService.exists(id)) {
			studentService.update(student);
			return new ResponseEntity<String>("Student updated successful!", HttpStatus.CREATED);
		}else
			return new ResponseEntity<String>("Student Not Found", HttpStatus.NOT_FOUND);
	}	
	
	@GetMapping("/{id}/courses/")
	public ResponseEntity<?> allStudentCourses(@PathVariable Integer id)
	{
		if(studentService.exists(id))
			return new ResponseEntity<>(studentService.studentCourses(id), HttpStatus.OK);
		else
			return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
	}
	
	@GetMapping("/{student_id}/courses/{course_id}/modules")
	public ResponseEntity<?> allStudentCourseModules(@PathVariable Integer student_id, @PathVariable Integer course_id)
	{
		if(studentService.exists(student_id) && studentCourseService.exists(course_id))
			return new ResponseEntity<>(studentService.studentCourseModules(student_id, course_id), HttpStatus.OK);
		else
			return new ResponseEntity<>("Student or Student Course Not Found", HttpStatus.NOT_FOUND);
	}
}
