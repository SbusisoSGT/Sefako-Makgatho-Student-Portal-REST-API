package org.sefako.makgatho.demo.controllers;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.sefako.makgatho.demo.models.Role;
import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.repositories.RoleRepository;
import org.sefako.makgatho.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/students")
public class StudentController {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/")
	public List<Student> index()
	{
		return studentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Student> show(@RequestParam Integer id)
	{
		return studentRepository.findById(id);
	}
	
	@PostMapping("/{role_id}")
	public ResponseEntity<?> store(@RequestParam Integer role_id, @RequestBody Student student)
	{
		if(roleRepository.existsById(role_id)) {
			Role role = roleRepository.findById(role_id).get();
			student.setRole(role);
			student.setRegisteredAt(new Date());
			studentRepository.save(student);
			return new ResponseEntity<>("Student registered successfully", HttpStatus.CREATED);
		}else
			return new ResponseEntity<>("Role Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@RequestParam Integer id, @RequestBody Student student)
	{
		studentRepository.save(student);
		
		return new ResponseEntity<String>("Student updated successful!", HttpStatus.CREATED);
	}	
}
