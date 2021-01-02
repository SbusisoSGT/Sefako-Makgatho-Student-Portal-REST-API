package org.sefako.makgatho.demo.services;

import java.util.Date;
import java.util.List;

import org.sefako.makgatho.demo.models.Course;
import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.models.StudentCourse;
import org.sefako.makgatho.demo.models.dto.StudentCourseDTO;
import org.sefako.makgatho.demo.repositories.CourseRepository;
import org.sefako.makgatho.demo.repositories.StudentCourseRepository;
import org.sefako.makgatho.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentCourseService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	CourseRepository courseRepository;
	
	@Autowired
	StudentCourseRepository studentCourseRepository;
	
	public boolean exists(Integer id)
	{
		return studentCourseRepository.existsById(id);
	}
	
	public List<StudentCourse> all()
	{
		return studentCourseRepository.findAll();
	}
	
	public StudentCourse find(Integer id)
	{
		return studentCourseRepository.findById(id).get();
	}
	
	public void save(StudentCourseDTO studentCourseDTO)
	{
		Student student = studentRepository.findById(studentCourseDTO.getStudent_id()).get();
		Course course = courseRepository.findById(studentCourseDTO.getCourse_id()).get();
		
		StudentCourse studentCourse = new StudentCourse();
		studentCourse.setStudent(student);
		studentCourse.setCourse(course);
		studentCourse.setRegisteredAt(new Date());
		studentCourse.setCurrentLevel(1);
		
		studentCourseRepository.save(studentCourse);
	}
	
	public void update(Integer id, StudentCourse studentCourse)
	{
		//StudentCourse course = studentCourseRepository.findById(id).get();
		
	}
	
	public void delete(Integer id) 
	{
		studentCourseRepository.deleteById(id);
	}
}
