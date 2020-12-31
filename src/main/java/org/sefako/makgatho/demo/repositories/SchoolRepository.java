package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.School;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepository<School, Integer>{
	//
}
