package com.example.demo.service;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.model.User;
import com.example.demo.service.impl.UserServiceImpl;

@SpringBootTest
public class UserServiceTest {
	@Autowired
	UserServiceImpl usi;
	
	// Unit Test
	//@Test
	public void registerUserTest() {
		User user1 = new User("Richard", "Chao", "rich", "chao");
		usi.registerUser(user1);
		User user2 = new User("Kei", "Nishikori", "kei", "nish");
		usi.registerUser(user2);
	}
	
	//@Test
	public void findAllUserTest() {
		List<User> list = usi.findAllUser();
		
		for (User user : list) {
			System.out.println("user_id:" + user.getUserId() + "\tfirstname:" + user.getFirstname() + "\tlastname:"
					+ user.getLastname() + "\tusername:" + user.getUsername() + "\tpassword:" + user.getPassword());
		}
	}
	//@Test
		public void findUserByIdTest() {
			assertEquals(usi.findUserById(2).getFirstname(), "Kei");
	}
		
	//@Test
	public void findUserIdByUsernameTest() {
		assertEquals(usi.findUserIdByUsername("kei"), 2);
	}
	
	//@Test
	public void userExistTest() {
		System.out.println(usi.userExist("rich"));
		System.out.println(usi.userExist("notRich"));
	}
	
	//@Test
	public void loginUserTest() {
		System.out.println(usi.loginUser("rich", "chao"));
		System.out.println(usi.loginUser("rich", "pao"));
	}
	
	//@Test
	public void updateUserTest() {
		usi.updateUser(1, "Victor", "Chao", "vic", "cao");
	}
	
	// @Test
	public void removeUserTest() {
		usi.removeUser(1);
	}
	
	// Functional Test
	@Test
	public void registerLoginUpdateRemoveUserTest() {
		// Register
		String username = "rich";
		String password = "123";
		User user = new User("Richard", "Chao", username, password);
		assertTrue(usi.registerUser(user));
		assertTrue(usi.userExist(username));
		
		// Register same user => Shouldn't allow to register user with same username
		assertFalse(usi.registerUser(user));
		
		// Register with same username
		assertFalse(usi.registerUser(user));
		
		// Login
		assertEquals(usi.loginUser(username, password), "rich");
		
		// Update Info
		int user_id = usi.findUserIdByUsername(username);
		usi.updateUser(user_id, "newRichard", "newChao", "newRich", "456");
		User updatedUser = usi.findUserById(user_id);
		assertEquals(updatedUser.getFirstname(), "newRichard");
		assertEquals(updatedUser.getLastname(), "newChao");
		assertEquals(updatedUser.getUsername(), "newRich");
		assertEquals(updatedUser.getPassword(), "456");
		
		// Remove User
		usi.removeUser(user_id);
		assertFalse(usi.userExist(username));
	}
	
}
