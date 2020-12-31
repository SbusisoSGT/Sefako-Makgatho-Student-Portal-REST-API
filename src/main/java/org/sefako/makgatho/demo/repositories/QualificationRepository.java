package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.Qualification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualificationRepository extends JpaRepository<Qualification, Integer>{
	//
}
