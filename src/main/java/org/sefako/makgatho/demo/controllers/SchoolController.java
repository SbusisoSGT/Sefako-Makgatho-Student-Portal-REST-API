package org.sefako.makgatho.demo.controllers;

import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.Course;
import org.sefako.makgatho.demo.models.School;
import org.sefako.makgatho.demo.repositories.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class SchoolController {

	@Autowired
	SchoolRepository schoolRepository;
	
	@GetMapping("/schools/")
	public List<School> index()
	{
		return schoolRepository.findAll();
	}
	
	@GetMapping("/schools/{id}")
	public School show(@PathVariable Integer id)
	{
		return schoolRepository.findById(id).get();
	}
	
	@GetMapping("/schools/{id}/courses/")
	public Set<Course> schoolCourses(@PathVariable Integer id)
	{
		Set<Course> schoolCourses = null;
		
		if(schoolRepository.existsById(id))
			schoolCourses = schoolRepository.findById(id).get().getCourses();
		
		return schoolCourses;
	}
}
