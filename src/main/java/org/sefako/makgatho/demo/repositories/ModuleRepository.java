package org.sefako.makgatho.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.sefako.makgatho.demo.models.Module;

@Repository
public interface ModuleRepository extends JpaRepository<Module, Integer>{
	//
}
