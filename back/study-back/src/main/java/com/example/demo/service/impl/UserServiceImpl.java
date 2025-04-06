package com.example.demo.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;
import com.example.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	
	UserRepository ur;

	@Override
	public boolean registerUser(User user) {
		if (!userExist(user.getUsername())) {
			ur.save(user);
			return true;
		}
		return false;
		
	}

	@Override
	public List<User> findAllUser() {
		return ur.findAll();
	}
	@Override
	public User findUserById(int user_id) {
		List<User> list = ur.findById(user_id);
		return list.get(0);
	}
	
	@Override
	public int findUserIdByUsername(String username) {
		List<User> list = ur.findByUsername(username);  
		User user = list.get(0);
		return user.getUserId();
	}
	
	@Override
	public boolean userExist(String username) {
		List<User> list = ur.findByUsername(username);
		if (list.isEmpty()) {
			return false;
		}
		return true;
	}
	
	@Override
	public String loginUser(String username, String password) {
		List<User> list = ur.findByUsernameAndPassword(username, password);
		if (list.isEmpty()) {
			return null;
		}
		return username;
	}

	@Override
	public boolean updateUser(int user_id, String firstname, String lastname, String username, String password) {
		
		if (userExist(username)) {
			return false;
		} else {
			List<User> list = ur.findById(user_id);
			User user = list.get(0);
			
			user.setFirstname(firstname);
			user.setLastname(lastname);
			user.setUsername(username);
			user.setPassword(password);
			
			ur.save(user);
			return true;
		}
		
	}

	@Override
	public String removeUser(int user_id) {
		List<User> list = ur.findById(user_id);
		User user = list.get(0);
		ur.delete(user);
		return user.getFirstname();
	}

}
