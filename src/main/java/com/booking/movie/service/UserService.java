package com.booking.movie.service;

import java.util.List;

import com.booking.movie.model.User;
import com.google.gson.JsonElement;

public interface UserService {

	List<User> getAllUsers();

	User getUserByID(Integer id);

	void addUser(String username, String password, String role, int userID);

	void updateUser(String username, String password, String role, int userID);

	User getUserByCredentials(String username, String password);
}
