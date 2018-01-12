package com.commons.auth.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.commons.auth.model.Role;
import com.commons.auth.model.User;
import com.commons.auth.repository.RoleRepository;
import com.commons.auth.repository.UserRepository;
import com.commons.auth.utility.AppConstant;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;
	@Autowired
	private RoleRepository roleRepository;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Override
	public void save(User user) throws Exception{
		try{
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			Role role = new Role();
			role.setId(AppConstant.DOCUMENT_USER_ID);
			role.setName(AppConstant.DOCUMENT_USER_NAME);
			user.setRoles(role);
			userRepository.save(user);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User findByUsername(String username) throws Exception{
		try{
			return userRepository.findByUsername(username);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}

	@Override
	public User findByEmail(String email) throws Exception {
		try{
			return userRepository.findByEmail(email);
		}catch(Exception e){
			e.printStackTrace();
			throw e;
		}
	}
}
