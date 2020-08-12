package com.badbadcode.application.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.badbadcode.application.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	public Optional<User> findByuserName(String username);
}
