package org.sefako.makgatho.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.sefako.makgatho.demo.models.Department;
import org.sefako.makgatho.demo.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/departments")
public class DepartmentController {

	@Autowired 
	DepartmentRepository departmentRepository;
	
	@GetMapping("/")
	public List<Department> index()
	{
		return departmentRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Department> show(@PathVariable Integer id)
	{
		return departmentRepository.findById(id);
	}
}
