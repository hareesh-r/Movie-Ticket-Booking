package com.booking.movie.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.movie.model.User;
import com.booking.movie.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}

	@Override
	public User getUserByID(Integer id) {
		return userRepository.getUserByID(id);
	}

	@Override
	public void addUser(String username, String password, String role, int userID) {
		userRepository.addUser(username, password, role, userID);
	}

	@Override
	public void updateUser(String username, String password, String role, int userID) {
		userRepository.updateUser(username, password, role, userID);
	}

	@Override
	public User getUserByCredentials(String username, String password) {
		return userRepository.getUserByCredentials(username,password);
	}

}