package com.booking.movie.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.booking.movie.model.User;
import com.booking.movie.service.UserService;
import com.google.gson.Gson;


@CrossOrigin("http://127.0.0.1:5500/")
@RestController
public class UserController {

	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public String viewUsers() {
		Gson gson = new Gson();
		return gson.toJson(userService.getAllUsers());
	}
	
	@RequestMapping(value = "/users/login", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public User checkValidUser(@RequestParam Map<String, String> requestParams) {
		String username = requestParams.get("username");
		String password = requestParams.get("password");
		User invalidUser = new User(0,"invalid","invalid","user");
		User isUser = userService.getUserByCredentials(username, password);
		System.out.println(isUser==null ? invalidUser : isUser);
		return isUser==null ? invalidUser : isUser;
	}

	@RequestMapping(value = "/users/id", produces = "application/json", method = RequestMethod.GET)
	@ResponseBody
	public String viewUserByID(@RequestParam String id) {
		Gson gson = new Gson();
		return gson.toJson(userService.getUserByID(Integer.parseInt(id)));
	}

	@RequestMapping(value = "/users", produces = "application/json", method = RequestMethod.POST)
	@ResponseBody
	public String addUser(@RequestParam Map<String, String> requestParams) throws Exception {
		try {
			String username = requestParams.get("username");
			String password = requestParams.get("password");
			String role = requestParams.get("role");
			int userID = Integer.parseInt(requestParams.get("userID"));
			userService.addUser(username, password, role, userID);
			return "User Added Successfully";
		} catch (Exception e) {
			return "User addition Failed please check for errors";
		}
	}

	@RequestMapping(value = "/users", produces = "application/json", method = RequestMethod.PUT)
	@ResponseBody
	public String updateUser(@RequestParam Map<String, String> requestParams) throws Exception {
		try {
			String username = requestParams.get("username");
			String password = requestParams.get("password");
			String role = requestParams.get("role");
			int userID = Integer.parseInt(requestParams.get("userID"));
			userService.updateUser(username, password, role, userID);
			return "User Updated Successfully";
		} catch (Exception e) {
			return "User Updation Failed please check for errors";
		}
	}

}
