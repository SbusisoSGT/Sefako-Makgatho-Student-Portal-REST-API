package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.Query;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
	@Query("SELECT s FROM Student s WHERE s.studentNum = :studentNum")
	Student findByStudentNum(@Param("studentNum") Long studentNum);
}
