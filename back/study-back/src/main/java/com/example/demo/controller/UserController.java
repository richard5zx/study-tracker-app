package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;

@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
	@Autowired
	UserServiceImpl usi;
	
	// C
	@PostMapping("registerUser")
	public String registerUser(@RequestBody User user) {
		if(usi.registerUser(user)) {
			return "Registration Successful";
		}
		return "Registration Unsuccessful";
	}
	
	// R
	@GetMapping("loginUser/{username}/{password}")
	public String loginUser(
			@PathVariable("username") String username,
			@PathVariable("password") String password				
			) 
	{
		if(usi.loginUser(username, password) == null) {
			return "Login Unsuccessful";
		} else {
			return "Login Successful";
		}
	}
	
	// U
	@PutMapping("updateUser/{user_id}/{firstname}/{lastname}/{username}/{password}")
	public String updateUser(
			@PathVariable("user_id") String user_id,
			@PathVariable("firstname") String firstname,
			@PathVariable("lastname") String lastname,
			@PathVariable("username") String username,
			@PathVariable("password") String password
			)
	{
		int user_id_int = Integer.parseInt(user_id);
		if(usi.updateUser(user_id_int, firstname, lastname, username, password)) {
			return "Update Successful";
		} else {			
			return "Update Unsuccessful";
		}
	}
	
	// D
	@DeleteMapping("deleteUser/{user_id}")
	public String deleteUser(@PathVariable("user_id") int user_id) {
		String deleted_user = usi.removeUser(user_id);
		return deleted_user + " is deleted";
	}
	
}
