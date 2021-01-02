package org.sefako.makgatho.demo.controllers;

import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.sefako.makgatho.demo.models.Course;
import org.sefako.makgatho.demo.models.CourseModule;
import org.sefako.makgatho.demo.repositories.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("/courses")
public class CourseController {

	@Autowired
	CourseRepository courseRepository;
	
	@GetMapping("/")
	public List<Course> index()
	{
		return courseRepository.findAll();
	}
	
	@GetMapping("/{id}")
	public Optional<Course> show(@PathVariable Integer id)
	{
		return courseRepository.findById(id);
	}
	
	@GetMapping("/{id}/modules")
	public Set<CourseModule> courseModules(@PathVariable Integer id)
	{
		Course course = courseRepository.findById(id).get();
		return course.getCourseModules();
	}
}
