package org.sefako.makgatho.demo.controllers;

import java.util.List;

import org.sefako.makgatho.demo.models.StudentModule;
import org.sefako.makgatho.demo.models.dto.StudentModuleDTO;
import org.sefako.makgatho.demo.services.StudentModuleService;
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
@RequestMapping("/students/modules/")
public class StudentModuleController {

	@Autowired 
	StudentModuleService studentModuleService;
	
	@GetMapping("/")
	public List<StudentModule> index()
	{	
		return studentModuleService.all();
	}
	
	@GetMapping("/{id}")
	public StudentModule show(@PathVariable Integer id)
	{
		return studentModuleService.find(id);
	}
	
	@PostMapping("/")
	public ResponseEntity<?> store(@RequestBody StudentModuleDTO studentModuleDTO)
	{
		if(studentModuleService.save(studentModuleDTO))
			return new ResponseEntity<>("Student module created successfully" ,HttpStatus.CREATED);
		else
			return new ResponseEntity<>("Student or Module Not Found", HttpStatus.NOT_FOUND);
	}
}
