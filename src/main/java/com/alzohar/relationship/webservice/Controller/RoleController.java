package com.alzohar.relationship.webservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alzohar.relationship.webservice.Exception.RoleNotFound;
import com.alzohar.relationship.webservice.Repository.RoleRepository;
import com.alzohar.relationship.webservice.entity.Role;

@RestController
@RequestMapping("api")
public class RoleController {

	@Autowired
	RoleRepository repository;

	@GetMapping("/roles")
	public List<Role> getRoles() {
		List<Role> list = repository.findAll();
		if (list.isEmpty()) {
			throw new RoleNotFound("Role list is Empty, Zero Records Found.");
		}
		return list;
	}

	@PostMapping("/role")
	public Role addRole(@RequestBody Role role) {
		return repository.save(role);
	}

	@DeleteMapping("/role/{id}")
	public String deleteRole(@PathVariable("id") int id) {
		repository.deleteById(id);
		return "Role is deleted Successfully";
	}
}
