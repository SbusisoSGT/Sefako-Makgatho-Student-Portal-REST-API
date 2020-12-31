package org.sefako.makgatho.demo.controllers;

import java.util.List;

import org.sefako.makgatho.demo.models.Permission;
import org.sefako.makgatho.demo.repositories.PermissionRepository;
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
@RequestMapping("/permissions")
public class PermissionController {

	@Autowired()
	PermissionRepository permissionRepository;
	
	@GetMapping("/")
	public List<Permission> index()
	{
		return permissionRepository.findAll();
	}
	
	@GetMapping("/{name}")
	public ResponseEntity<?> show(@RequestParam String name)
	{
		if(permissionRepository.findByName(name) == null) 
			return new ResponseEntity<String>("Permission Not Found!", HttpStatus.NOT_FOUND);
		else
			return new ResponseEntity<Permission>(permissionRepository.findByName(name), HttpStatus.OK);
	}
	
	
	@PostMapping("/")
	public ResponseEntity<?> store(@RequestBody Permission permission)
	{
		permissionRepository.save(permission);
		
		return new ResponseEntity<String>("Permission created!", HttpStatus.CREATED);
	}
}


