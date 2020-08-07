package com.badbadcode.application.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.badbadcode.application.entity.User;
import com.badbadcode.application.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	UserRepository repo;
	
	@Override
	public Iterable<User> getAllUsers() {
		return repo.findAll();
	}

}
