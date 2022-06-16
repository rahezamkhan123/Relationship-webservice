package com.alzohar.relationship.webservice.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alzohar.relationship.webservice.Repository.UserRepository;
import com.alzohar.relationship.webservice.entity.User;

@RestController
@RequestMapping("api")
public class UserController {

	@Autowired
	UserRepository repository;

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return repository.findAll();
	}

	@PostMapping("/users")
	public User addUser(@RequestBody User user) {
		return repository.save(user);
	}

}
