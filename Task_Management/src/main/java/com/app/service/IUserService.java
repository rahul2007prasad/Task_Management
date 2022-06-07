package com.app.service;

import java.util.List;

import com.app.dto.LoginRequest;
import com.app.pojos.Role;
import com.app.pojos.Users;

public interface IUserService {

	//register
	
	Users registerOrEditUser(Users user);
	
	//authentication
	
	Users auhenticateUser(LoginRequest request);
	
	List<Users> getUsersByRole(Role role);
	
	Users findByEmail(String email);
	
	Users findById(Integer id);
	
	Users edit(Users user , int userId);
	
	String deleteUserById(Integer id);
	
	List<Users> getUserByName(String fname);
	
	Users getUserByEmail(String email);
	
	int countUsers();
	
}
