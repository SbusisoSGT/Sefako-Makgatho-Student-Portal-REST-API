package org.sefako.makgatho.demo.controllers;

import java.util.List;
import java.util.Optional;

import org.sefako.makgatho.demo.models.Module;
import org.sefako.makgatho.demo.repositories.ModuleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/modules")
public class ModuleController {

	@Autowired
	ModuleRepository moduleRepository;
	
	@GetMapping("/")
	public List<Module> index()
	{
		return moduleRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Module> show(@PathVariable Integer id)
	{
		return moduleRepository.findById(id);
	}
}
