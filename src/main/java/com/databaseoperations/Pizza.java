package com.databaseoperations;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.dataclasses.PizzaToppings;
import com.dataclasses.Pizzatypes;


public class Pizza {
	
	
	
	public static ArrayList<Pizzatypes> getPizzas() {
		
		ArrayList<Pizzatypes> list = new ArrayList<>();
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		try {
			String url = "jdbc:mysql://localhost:3306/pizza_shop";
			Connection connection = DriverManager.getConnection(url,"root","althaf");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM pizzatypes");
			
			while(resultset.next()) {
				Pizzatypes p1 = new Pizzatypes(resultset.getInt(1),resultset.getString(2),resultset.getInt(3));
				list.add(p1);
				
				
				
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
	
	public ArrayList<PizzaToppings> getToppings(){
		
		ArrayList<PizzaToppings> list = new ArrayList<>();
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		try {
			String url = "jdbc:mysql://localhost:3306/pizza_shop";
			Connection connection = DriverManager.getConnection(url,"root","althaf");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM pizzatoppings");
			
			while(resultset.next()) {
				PizzaToppings p1 = new PizzaToppings(resultset.getInt("id"),resultset.getString("Toppings"),resultset.getInt("topping_price"));
				list.add(p1);
				
				
				
			}
			
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
	

}
