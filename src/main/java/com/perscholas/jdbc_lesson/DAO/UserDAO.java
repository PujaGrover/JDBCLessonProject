package com.perscholas.jdbc_lesson.DAO;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO extends AbstractDAO implements UserDAOI 

{
	@Override
	
	public List<User> getAllUsers() throws ClassNotFoundException, SQLException {
		
		List<User> allUsers = null;
		User user = null;
		
		this.connect();
		
		//PreparedStatement from AbstractDAO is assigned SQL.GET_ALL_USERS enum value
		this.ps = this.conn.prepareStatement(SQL.GET_ALL_USERS.getQuery());
		//the query could also be here as long as there is a string there.
	//	this.myQuery;
		
		this.rs = this.ps.executeQuery();
		
		allUsers= new ArrayList<>();
		
		while (this.rs.next()) {
		//	System.out.println(this.rs.getString(1));
			//declare a new user every single time.
			user = new User();
			user.setEmail(rs.getString(1));
			user.setName(rs.getString(2));
			user.setPassword(rs.getString(3));
			allUsers.add(user);
		}

		this.dispose();
		return allUsers;
	}
	
	public static void main (String[] args) throws ClassNotFoundException, SQLException {
		UserDAO u_dao = new UserDAO();
		u_dao.getAllUsers();
		List<User> allUsers = u_dao.getAllUsers();
		for (User u :allUsers) {
			System.out.println(u.getName());
		}
	}

	@Override
	public User getUserByEmail(String email) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	

}
