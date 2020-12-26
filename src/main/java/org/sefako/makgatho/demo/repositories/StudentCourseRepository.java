package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.StudentCourse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentCourseRepository extends JpaRepository<StudentCourse, Integer> {
	//
}
