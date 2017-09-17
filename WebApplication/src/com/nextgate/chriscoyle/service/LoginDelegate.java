package com.nextgate.chriscoyle.service;

import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.nextgate.chriscoyle.service.UserService;

@Service
public class LoginDelegate{
	
	@Autowired
	private UserService userService;

	public UserService getUserService(){

		return this.userService;
	}

	public void setUserService(UserService userService)
	{
		this.userService = userService;
	}

	public boolean isValidUser(String username, String password) throws SQLException
	{
		return userService.isValidUser(username, password);
	}
}