package com.perscholas.jdbc_lesson;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCApp {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub
	Class.forName("org.mariadb.jdbc.Driver");
	String url = "jdbc:mariadb://localhost:3306/jdbctest";
	String username = "root";
	String password = "root";
	Connection conn = DriverManager.getConnection(url, username, password);
	System.out.println("Connection Made!! stop crying.");
	
	
	String sql = "select * from users";
	
	Statement stmt = conn.createStatement();
	ResultSet rs = stmt.executeQuery(sql);
	stmt.executeQuery(sql);
	
	while (rs.next()) {
		System.out.println(rs.getString(1));
		System.out.println(rs.getString(2));
		System.out.println(rs.getString(3));
	}
	
	
	conn.close();
	}

}
