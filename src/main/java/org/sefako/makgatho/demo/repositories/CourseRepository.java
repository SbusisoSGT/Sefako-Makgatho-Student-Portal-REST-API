package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	//
}
