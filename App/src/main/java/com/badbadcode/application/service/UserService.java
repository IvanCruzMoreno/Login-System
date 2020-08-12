package com.badbadcode.application.service;


import com.badbadcode.application.entity.User;

public interface UserService {

	public Iterable<User> getAllUsers();

	public User createUser(User user) throws Exception;
}
