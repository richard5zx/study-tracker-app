package com.example.demo.repository;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	// C
	List<User> findById(int user_id);
	
	// R
	List<User> findByFirstname(String firstname);
	
	List<User> findByLastname(String lastname);
	
	List<User> findByUsername(String username);
	
	List<User> findByUsernameAndPassword(String username, String password);
	
	
	@Query(value="SELECT * FROM user WHERE date_joined BETWEEN ?1 AND ?2", nativeQuery=true)
	List<User> findUserByDateJoined(Timestamp start, Timestamp end);
	
	// U
	
	// D
}
