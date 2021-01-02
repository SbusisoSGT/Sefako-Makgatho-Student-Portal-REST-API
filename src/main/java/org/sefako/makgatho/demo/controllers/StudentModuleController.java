package org.sefako.makgatho.demo.controllers;

import java.util.List;

import org.sefako.makgatho.demo.models.StudentModule;
import org.sefako.makgatho.demo.models.dto.StudentModuleDTO;
import org.sefako.makgatho.demo.repositories.ModuleRepository;
import org.sefako.makgatho.demo.repositories.StudentCourseRepository;
import org.sefako.makgatho.demo.repositories.StudentModuleRepository;
import org.sefako.makgatho.demo.services.StudentModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/students/modules/")
public class StudentModuleController {

	@Autowired
	ModuleRepository moduleRepository;
	
	@Autowired
	StudentCourseRepository studentCourseRepository;
	
	@Autowired 
	StudentModuleService studentModuleService;
	
	@Autowired
	StudentModuleRepository studentModuleRepository;
	
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
		if(studentCourseRepository.existsById(studentModuleDTO.getStudent_course_id()) && moduleRepository.existsById(studentModuleDTO.getModule_id()))
		{
			studentModuleService.save(studentModuleDTO);
			return new ResponseEntity<>("Student module created successfully" ,HttpStatus.CREATED);
		}
		else
			return new ResponseEntity<>("Student or Module Not Found", HttpStatus.NOT_FOUND);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody StudentModule studentModule)
	{
		if(studentModuleService.exists(id))
		{
			studentModuleService.update(id, studentModule);
			return new ResponseEntity<>("Student module updated successfully!", HttpStatus.OK);
		}else
			return new ResponseEntity<>("Student Module Not Found", HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id)
	{
		if(studentModuleService.exists(id))
		{
			studentModuleService.delete(id);
			return new ResponseEntity<>("Student module deleted successfully!", HttpStatus.OK);
		}else 
			return new ResponseEntity<>("Student Module Not Found", HttpStatus.NOT_FOUND);
	}
}
