package com.app.service;

import java.util.ArrayList;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.app.dao.UserDao;
import com.app.pojos.Users;

@Transactional
@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserDao userRepo;
	
	 public UserDetailsServiceImpl() {
System.out.println("In constr of "+getClass().getName());
	}
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		System.out.println("Email : " + email);
		Users user = userRepo.findByEmail(email);
		System.out.println("User drom loaduserByUsername"+user);
		return new org.springframework.security.core.userdetails.User(Integer.toString(user.getId()), user.getPassword(), new ArrayList<GrantedAuthority>());
		
	}
	
	public UserDetails loadUserById(Integer id) throws UsernameNotFoundException{
		System.out.println("\n ...IN USERDetailsServiceImpl.loadUserById");
		System.out.println("Id" +id);
		Users user =userRepo.findById(id).get();
		return new org.springframework.security.core.userdetails.User(Integer.toString(user.getId()), user.getPassword(), new ArrayList<GrantedAuthority>());
	}

}
