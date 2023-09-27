package com.databaseoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserAuthenticationDao {
	
	public Connection connectDatabase(String url,String DBuser,String DBpassword) {
		Connection connection=null;
		try {
			 connection = DriverManager.getConnection(url,DBuser,DBpassword);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return connection;
	}
	
	String url="jdbc:mysql://localhost:3306/pizza_shop";
	String DBusername = "root";
	String DBpassword ="althaf";
	
	String sql="SELECT * FROM userscredentials WHERE username=? AND password=?";

	public boolean checkUser(String username,String password) {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		try {
			Connection connection = DriverManager.getConnection(url,DBusername,DBpassword);
			PreparedStatement statement = connection.prepareStatement(sql);
			statement.setString(1, username);
			statement.setString(2, password);
			ResultSet resultset = statement.executeQuery();
			if(resultset.next() == true) {
				return true;
			}
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		
		
		
		
		return false;
	}

}
