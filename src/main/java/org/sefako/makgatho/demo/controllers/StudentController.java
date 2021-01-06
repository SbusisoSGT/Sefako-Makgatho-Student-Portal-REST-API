package org.sefako.makgatho.demo.controllers;

import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.models.StudentCourse;
import org.sefako.makgatho.demo.models.dto.StudentDTO;
import org.sefako.makgatho.demo.repositories.StudentRepository;
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
	StudentRepository studentRepository;
	
	@GetMapping
	public List<Student> index()
	{
		return studentService.all();
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@PathVariable Integer id)
	{
		if(studentRepository.existsById(id))
			return new ResponseEntity<>(studentService.find(id), HttpStatus.OK);
		else
			return new ResponseEntity<>("Student Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping
	public ResponseEntity<?> store(@RequestBody StudentDTO studentDTO)
	{
		if(studentService.save(studentDTO))
			return new ResponseEntity<>("Student registered successfully", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Role Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody Student student)
	{
		studentRepository.save(student);
		
		return new ResponseEntity<String>("Student updated successful!", HttpStatus.CREATED);
	}	
	
	@GetMapping("/{id}/courses/")
	public Set<StudentCourse> allStudentCourses(@PathVariable Integer id)
	{
		return studentService.studentCourses(id);
	}
}
