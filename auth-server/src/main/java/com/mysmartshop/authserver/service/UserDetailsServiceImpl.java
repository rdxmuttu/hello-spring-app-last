package com.mysmartshop.authserver.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.mysmartshop.authserver.model.User;
import com.mysmartshop.authserver.repository.UserRepo;

@Service
public class UserDetailsServiceImpl implements UserDetailsService{

	@Autowired
	UserRepo repo;
	
	 public UserDetails loadUserByUsername(String username) {
		User user =  repo.findByUsername(username);
		return new UserDetailsModel(user);
	}
	 
	 
	
}
