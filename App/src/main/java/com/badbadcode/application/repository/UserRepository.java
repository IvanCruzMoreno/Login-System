package com.badbadcode.application.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.badbadcode.application.entity.User;

@Repository
public interface UserRepository extends CrudRepository<User, Long>{
	
}
