package com.badbadcode.application.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.badbadcode.application.entity.Role;
import com.badbadcode.application.entity.User;
import com.badbadcode.application.repository.UserRepository;

@Service
@Transactional
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository repo;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User appUser = repo.findByuserName(username)
				.orElseThrow(() -> new UsernameNotFoundException("Login Username Invalido"));


		Set grantList = new HashSet();
		//Crear la lista de los roles/accessos que tienen el usuarios
		for(Role roles: appUser.getRoles()) {
			GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(roles.getDescription());
			grantList.add(grantedAuthority);
		}
		 //Crear y retornar Objeto de usuario soportado por Spring Security
		UserDetails user = (UserDetails) new org.springframework.security.core.userdetails.User(username, appUser.getPassword(),grantList);
		return user;
	}

}
