package com.example.demo.service;

import java.util.List;

import com.example.demo.model.User;

public interface UserService {
	
	// C
	public boolean registerUser(User user);
	
	// 
	public List<User> findAllUser();
	public User findUserById(int user_id);
	public int findUserIdByUsername(String username);
	public boolean userExist(String username);
	public String loginUser(String username, String password);
	
	// U
	public boolean updateUser(int user_id, String firstname, String lastname,String username, String password);
	
	// D
	public String removeUser(int user_id);

}