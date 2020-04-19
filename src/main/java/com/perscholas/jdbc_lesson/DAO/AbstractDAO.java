package com.perscholas.jdbc_lesson.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

	public abstract class AbstractDAO {
//	public class AbstractDAO {
		
	
	private final String url = "jdbc:mariadb://localhost:3306/jdbctest";
	private final String user = "root";
	private final String password = "root";
	//private final Driver driver =  new org.mariadb.jdbc.Driver();
	private final String driver =  "org.mariadb.jdbc.Driver";
	
	protected Connection conn = null;
	protected PreparedStatement ps = null;
	protected ResultSet rs = null;
	
	public void connect() throws ClassNotFoundException {
		try 
		{
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
		//	System.out.println("the try worked.");
			
			
		}
		catch (SQLException | ClassNotFoundException e)
		{
			System.out.println(e.getMessage());
		}
	
	
//	Connection conn = DriverManager.getConnection(url, username, password);
//	System.out.println("Connection Made!! stop crying.");
	
	}
	
	public void dispose() {
		try {
			if (!rs.equals(null)) {
				if (!!rs.isClosed()) {
					rs.close();
				}
			}
			if(ps !=null) {
				if(!ps.isClosed()) {
					ps.close();
				}
			}
			if (conn !=null) {
				if (!conn.isClosed()) {
					conn.close();
				}
			}
		}
		catch (SQLException e)
		{
			System.out.println(e.getMessage());
		}
	
	}
	
	
	
//	public static void main(String[] args) throws ClassNotFoundException {
//		
//		AbstractDAO a_dao = new AbstractDAO();
//		a_dao.connect();
//		System.out.println("Success!");
//	}
	
}
