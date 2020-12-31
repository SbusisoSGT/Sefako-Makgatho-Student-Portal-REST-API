package org.sefako.makgatho.demo.controllers;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.Permission;
import org.sefako.makgatho.demo.models.Role;
import org.sefako.makgatho.demo.repositories.RoleRepository;
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
@RequestMapping("/roles/")
public class RoleController {

	@Autowired
	RoleRepository roleRepository;
	
	@GetMapping("/")
	public List<Role> index()
	{
		return roleRepository.findAll();
	}
	
	@PostMapping("/")
	public ResponseEntity<?> store(@RequestBody Role role)
	{
		roleRepository.save(role);
		
		return new ResponseEntity<String>("Role created successfully!", HttpStatus.CREATED);
	}
	
	@PostMapping("/{id}/permissions")
	public ResponseEntity<?> storePermissions(@RequestBody Permission permission, @RequestParam Integer id)
	{
		if(roleRepository.existsById(id)) {
			Set<Permission> permissions = new HashSet<Permission>();
			permissions.add(permission);
			roleRepository.findById(id).ifPresent(role -> {role.setPermissions(permissions);});
			
			return new ResponseEntity<String>("Permissions Added to Role successfully!", HttpStatus.CREATED);
		}else 
			return new ResponseEntity<String>("Role Not Found", HttpStatus.NOT_FOUND);
	}
}
