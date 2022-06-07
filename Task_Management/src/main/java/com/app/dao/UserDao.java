package com.app.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.pojos.Users;

public interface UserDao extends JpaRepository<Users, Integer>{

	Users findByEmail(String email);
	List<Users> findByFirstName(String firstName);

	Optional<Users> findByEmailAndPassword(String email, String password);

}
