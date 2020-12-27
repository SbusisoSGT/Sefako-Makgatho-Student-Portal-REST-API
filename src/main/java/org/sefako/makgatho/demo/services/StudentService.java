package org.sefako.makgatho.demo.services;

import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.sefako.makgatho.demo.models.Role;
import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.models.User;
import org.sefako.makgatho.demo.models.dto.StudentDTO;
import org.sefako.makgatho.demo.repositories.RoleRepository;
import org.sefako.makgatho.demo.repositories.StudentRepository;
import org.sefako.makgatho.demo.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentService {

	@Autowired
	StudentRepository studentRepository;
	
	@Autowired
	RoleRepository roleRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public List<Student> all()
	{
		return studentRepository.findAll();
	}
	
	public Student find(Integer id)
	{
		return studentRepository.findById(id).get();
	}
	
	public boolean save(StudentDTO studentDTO)
	{
		if(roleRepository.existsById(studentDTO.getRole_id())) {
			User user  = new User();
			user.setFirstname(studentDTO.getFirstname());
			user.setLastname(studentDTO.getLastname());
			user.setEmail(studentDTO.getEmail());
			user.setPassword(studentDTO.getPassword());
			
			Role role = roleRepository.findById(studentDTO.getRole_id()).get();
			Set<Role> roles = new HashSet<Role>();
			roles.add(role);
			
			user.setRoles(roles);
			userRepository.save(user);
			
			Student student = new Student();
			student.setStudentNum(studentDTO.getStudentNum());
			student.setRegisteredAt(new Date());
			student.setUser(user);
			studentRepository.save(student);
			
			return true;
		}else
			return false;
	}
	
	public void update(StudentDTO StudentDTO)
	{
		//
	}
}




