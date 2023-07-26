package com.mysmartshop.authserver.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mysmartshop.authserver.model.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUsername(String username);
}
