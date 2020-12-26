package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.StudentModule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentModuleRepository extends JpaRepository<StudentModule, Integer>{
	//
}
