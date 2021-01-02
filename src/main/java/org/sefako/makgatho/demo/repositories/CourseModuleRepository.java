package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.CourseModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseModuleRepository extends JpaRepository<CourseModule, Integer>{
	//
}
