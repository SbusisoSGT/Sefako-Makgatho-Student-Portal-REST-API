package org.sefako.makgatho.demo.controllers;

import org.sefako.makgatho.demo.models.dto.StudentCourseDTO;
import org.sefako.makgatho.demo.repositories.StudentCourseRepository;
import org.sefako.makgatho.demo.services.StudentCourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/students/courses/")
public class StudentCoursesController {
	
	@Autowired
	StudentCourseRepository studentCourseRepository;
	
	@Autowired
	StudentCourseService studentCourseService;
	
	@GetMapping("/")
	public ResponseEntity<?> index()
	{
		return new ResponseEntity<>(studentCourseService.all(), HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> show(@RequestParam Integer id)
	{
		if(studentCourseRepository.existsById(id))
			return new ResponseEntity<>(studentCourseService.find(id), HttpStatus.OK);
		else
			return new ResponseEntity<>("Student course Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> store(@RequestBody StudentCourseDTO studentCourseDTO)
	{
		if(studentCourseService.save(studentCourseDTO))
			return new ResponseEntity<>("Student course registered successfully", HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Student or Course Not Found", HttpStatus.NOT_FOUND);
	}
}
