package com.badbadcode.application.service;

import java.util.Optional;
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
	
	private boolean checkUsernameAvailable(User user) throws Exception {
		Optional<User> userFound =  repo.findByuserName(user.getUserName());
		
		if(userFound.isPresent()) {
			 throw new Exception("Username no disponible");
		}
		return true;
	}
	
	private boolean checkPasswordValid(User user) throws Exception {
		if(!user.getPassword().equals(user.getConfirmPassword())) {
			throw new Exception("Password y confirm password no son iguales");
		}
		return true;
	}

	@Override
	public User createUser(User user) throws Exception {
		if(checkUsernameAvailable(user) && checkPasswordValid(user)) {
			user = repo.save(user);
		}
		return user;
	}

	@Override
	public User getUserById(Long id) throws Exception {
		User user = repo.findById(id).orElseThrow(() -> new Exception("User not found"));
		return user;
	}

	@Override
	public User updateUser(User user) throws Exception {
		User toUser = getUserById(user.getId());
		mapUser(user, toUser);
		return repo.save(toUser);
	}
	/**
	 * Map everythin but the password.
	 * @param from
	 * @param to
	 */
	protected void mapUser(User from,User to) {
		to.setUserName(from.getUserName());
		to.setFirstName(from.getFirstName());
		to.setLastName(from.getLastName());
		to.setEmail(from.getEmail());
		to.setRoles(from.getRoles());
	}

}
