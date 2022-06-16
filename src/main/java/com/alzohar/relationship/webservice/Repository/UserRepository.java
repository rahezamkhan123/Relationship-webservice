package com.alzohar.relationship.webservice.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.alzohar.relationship.webservice.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	@Query(value = "select * from relation_user o where o.name like %:name%", nativeQuery = true)
	List<User> findByName(String name);
}
