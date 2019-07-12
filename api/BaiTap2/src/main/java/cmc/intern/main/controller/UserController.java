package cmc.intern.main.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import cmc.intern.main.entity.User;
import cmc.intern.service.UserService;


@RestController
@CrossOrigin("*")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/users-manager")
	public List<User> getAllUser() {
		ArrayList<User> users=userService.getAllUser();
		return users;
	}
	
	@GetMapping("/get-user/{id}")
	public User getUser(@PathVariable(value="id") int id) {
		User user=userService.getUserById(id);
		System.out.println(user.getUserScoreRelates());
		return userService.getUserById(id);
	}
}
