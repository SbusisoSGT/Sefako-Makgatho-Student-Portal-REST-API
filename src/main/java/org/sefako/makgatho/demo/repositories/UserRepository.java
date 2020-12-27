package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	//
}
