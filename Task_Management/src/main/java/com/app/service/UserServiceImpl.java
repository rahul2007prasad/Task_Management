package com.app.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.dto.LoginRequest;
import com.app.pojos.Role;
import com.app.pojos.Users;

@Transactional
@Service

public class UserServiceImpl implements IUserService {

	 public UserServiceImpl() {
		 System.out.println("in constr of "+getClass().getName());
	 }
	
	 @Autowired
	 private UserDao userRepo;
	 
	
	@Override
	public Users registerOrEditUser(Users user) {

		return userRepo.save(user);
	}

	@Override
	public Users auhenticateUser(LoginRequest request) {
		return userRepo.findByEmailAndPassword(request.getEmail(),request.getPassword()).get();
		
		
	}

	@Override
	public List<Users> getUsersByRole(Role role) {
		
		return userRepo.findAll();
	}

	@Override
	public Users findByEmail(String email) {
		return userRepo.findByEmail(email);
		
	}

	@Override
	public Users findById(Integer id) {
		return userRepo.findById(id).get();
	}

	@Override
	public Users edit(Users user, int userId) {
		user.setPassword(userRepo.findById(userId).get().getPassword());
		user.setId(userId);
		return userRepo.save(user);
	}

	@Override
	public String deleteUserById(Integer id) {
		userRepo.deleteById(id);
		return "Deleted User with Id: "+id +" successfully";
		
	}

	@Override
	public List<Users> getUserByName(String fname) {
		return userRepo.findByFirstName(fname);
	}

	@Override
	public Users getUserByEmail(String email) {

		return userRepo.findByEmail(email);
	}

	@Override
	public int countUsers() {

		return (int) userRepo.count();
	}

	
}
