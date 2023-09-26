package com.databaseoperations;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.dataclasses.OrderDao;


public class OrdersDBOperations {
	
	String url="jdbc:mysql://localhost:3306/pizza_shop";
	String DBusername = "root";
	String DBpassword ="althaf";
	
	public ArrayList<OrderDao> getOrdersList() {
		ArrayList<OrderDao> list = new ArrayList<>();
		try {
			Connection connection = DriverManager.getConnection(url,DBusername,DBpassword);
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from pizza_orders");
			while(resultset.next()) {
				OrderDao order = new OrderDao();
				order.setId(resultset.getInt(1));
				order.setPizzaName(resultset.getString(2));
				order.setPizzaTopping(resultset.getString(3));
				order.setTotalBill(resultset.getInt(4));
				
				list.add(order);
			}
			System.out.println(list);
		}catch(SQLException ex) {
			ex.printStackTrace();
		}
		
		return list;
	}
	
	
	
	
	

}

