package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	//
}
