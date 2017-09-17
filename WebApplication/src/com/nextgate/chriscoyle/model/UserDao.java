package com.nextgate.chriscoyle.model;

import java.sql.SQLException;

public interface UserDao
{
		public boolean isValidUser(String username, String password) throws SQLException;
}
