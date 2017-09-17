package com.nextgate.chriscoyle.model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.nextgate.chriscoyle.model.UserDao;


@Repository
public class UserDaoImpl implements UserDao{
	
	@Autowired //Uses Springs Inversion of Control (IoC) Mechanism To Automatically Inject References To Classes. We Don Need The new Keyword
	DataSource dataSource;

	public DataSource getDataSource(){
		return this.dataSource;
	}

	public void setDataSource(DataSource dataSource){
		this.dataSource = dataSource;
	}

	/**
	 * Method isValidUser()
	 * 
	 * This Method Queries The Database With The Users 
	 * Login Details to See If They Exist
	 * 
	 * 1. Query Selects username And password From The DB
	 *    It Uses Placeholders (?) To Prevent SQL Injection
	 * 
	 * 2. Create Prepared Statement Object And Pass It The Query
	 * 
	 * 3. Set username On Prepared Statement 
	 * 
	 * 4. Set password On Prepared Statement 
	 * 
	 * 5. Execute Prepared Statement. Statement Will Be Sent To
	 *    The Database Where It Will Be Sanatised. This 
	 *    Prevents SQL Injection
	 *    
	 * 6. If The Query Returned A Result The The User Exists So
	 *    Return True
	 *    
	 * 7. Else Return False. The User Does Not Exist In The Database
	 */
	@Override
	public boolean isValidUser(String username, String password) throws SQLException{

		String query = "Select count(1) from ng_users where username = ? and password = ?";	// 1
		
		PreparedStatement pstmt = dataSource.getConnection().prepareStatement(query);		// 2
		pstmt.setString(1, username);														// 3
		pstmt.setString(2, password);														// 4
		ResultSet resultSet = pstmt.executeQuery();											// 5
		
		if (resultSet.next()){																
			return (resultSet.getInt(1) > 0);												// 6
		}
		else{
			return false;																	// 7
		}
	}
}