package com.shoes.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.shoes.entity.User;
import com.shoes.repository.UserRepository;
import com.shoes.service.UserService;



@Service
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private PasswordEncoder passwordEncoder;

	@Override
	public List<User> getUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByUsername(String username) {
		return userRepository.findByUsername(username);
	}

	@Override
	public boolean hasUserWithUsername(String username) {
		return userRepository.existsByUsername(username);
	}

	@Override
	public boolean hasUserWithEmail(String email) {
		return userRepository.existsByEmail(email);
	}

	@Override
	public User saveUser(User user) {
		return userRepository.save(user);
	}

	@Override
	public void deleteUser(User user) {
		userRepository.delete(user);
	}

	@Override
	public User validUsernameAndPassword(String username, String password) {
		User user = getUserByUsername(username);
		return passwordEncoder.matches(password, user.getPassword()) ? user : null;
	}

}
