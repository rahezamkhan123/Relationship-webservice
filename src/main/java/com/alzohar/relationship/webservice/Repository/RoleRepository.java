package com.alzohar.relationship.webservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alzohar.relationship.webservice.entity.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer> {

	@Query(value = "select * from relation_role o where o.name like %:name%", nativeQuery = true)
	List<Role> findByName(String name);
}
