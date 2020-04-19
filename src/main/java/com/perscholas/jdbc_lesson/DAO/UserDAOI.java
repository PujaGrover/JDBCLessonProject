package com.perscholas.jdbc_lesson.DAO;

import java.sql.SQLException;
import java.util.List;

public interface UserDAOI {
	//otherway 
	final String myQuery = "MyQuery";
	
	enum SQL {
		GET_ALL_USERS("SELECT * FROM USERS"), 
		GET_USERS_BY_EMAIL("SELECT * FROM USERS WHERE email=?");
		private final String query;

		
		//constructor.. a rare private constructor. only useful for the enum
		private SQL(String s) {
			this.query = s;
		}

		//method
		public String getQuery() {
			return query;
		}
	}
	
	List<User> getAllUsers() throws ClassNotFoundException, SQLException;
	User getUserByEmail(String email);

}
