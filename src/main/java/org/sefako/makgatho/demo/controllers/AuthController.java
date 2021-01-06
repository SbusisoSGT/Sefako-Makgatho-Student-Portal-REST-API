package org.sefako.makgatho.demo.controllers;

import org.sefako.makgatho.demo.models.dto.AuthRequest;
import org.sefako.makgatho.demo.models.Student;
import org.sefako.makgatho.demo.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class AuthController {
  @Autowired
  StudentRepository studentRepository;

  @PostMapping("/authenticate")
  public ResponseEntity<?> login(@RequestBody AuthRequest authRequest)
  {
    Student student = studentRepository.findByStudentNum(authRequest.getStudentNum());
    
    //authRequest.getPassword() == student.getUser().getPassword();
    if(student != null)
        return new ResponseEntity<>(student, HttpStatus.OK);
    else
      return new ResponseEntity<>("Student Number or Password incorrect!", HttpStatus.FORBIDDEN);
  }
}
