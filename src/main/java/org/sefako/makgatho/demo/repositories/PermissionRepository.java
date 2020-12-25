package org.sefako.makgatho.demo.repositories;

import org.sefako.makgatho.demo.models.Permission;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissionRepository extends JpaRepository<Permission, Integer>{
	Permission findByName(String name);
}
