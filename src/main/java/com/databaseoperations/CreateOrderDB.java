package com.databaseoperations;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import com.dataclasses.PizzaToppings;

public class CreateOrderDB {
	
	public static void createOrderOnSql(int pizzaNameId,int toppingNameId) {
		
		Random random = new Random();
		int randomNumber=0;
		while(true) {
			randomNumber = random.nextInt();
			if(randomNumber>0 && randomNumber < 10000) {
				break;
			}
		}
		
		//ordered pizza Details
		int id= random.nextInt();
		String pizza="";
		String topping="";
		int price=0;
		
		 
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		}catch(ClassNotFoundException ex) {
			ex.printStackTrace();
		}
		
		try {
			String url = "jdbc:mysql://localhost:3306/pizza_shop";
			Connection connection = DriverManager.getConnection(url,"root","althaf");
			
			String toppingSql= "SELECT * FROM pizzatoppings where id=?";
			String pizzaSql = "SELECT * FROM pizzatypes where pizza_id=?";
			
			PreparedStatement toppingStatement = connection.prepareStatement(toppingSql);
			toppingStatement.setInt(1, toppingNameId);
			ResultSet resultSetTopping = toppingStatement.executeQuery();
			
			PreparedStatement pizzaStatement = connection.prepareStatement(pizzaSql);
			pizzaStatement.setInt(1,pizzaNameId);
			ResultSet resultSetPizza = pizzaStatement.executeQuery();
			
			while(resultSetPizza.next()) {
				
				pizza=resultSetPizza.getString("pizza_name");
				price = price + resultSetPizza.getInt("pizza_price");
				
			}
			
			while(resultSetTopping.next()) {
				topping= resultSetTopping.getString("Toppings");
				price= price+ resultSetTopping.getInt("topping_price");
			}
			
			String updateQuery = "insert into pizza_orders VALUES (?,?,?,?) ";
			
			PreparedStatement ps = connection.prepareStatement(updateQuery);
			
			
			ps.setInt(1, id);
			ps.setString(2, pizza);
			ps.setString(3, topping);
			ps.setInt(4, price);
			
			ps.executeUpdate();
			System.out.println("New Order Updated");
			
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
	}

}
