package com.nextgate.chriscoyle.service;


import java.sql.SQLException;

import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import com.nextgate.chriscoyle.model.UserDao;
import com.nextgate.chriscoyle.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDao userDao;

	
	public UserDao getUserDao(){
		return this.userDao;
	}

	public void setUserDao(UserDao userDao){
		this.userDao = userDao;
	}

	@Override
	public boolean isValidUser(String username, String password) throws SQLException{
		return userDao.isValidUser(username, password);
	}
}
