package com.databaseoperations;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

import com.dataclasses.Order;
import com.dataclasses.PizzaToppings;
import com.dataclasses.Pizzatypes;

public class ProductsDao {

	UserAuthenticationDao connectDB = new UserAuthenticationDao();
	// Connection connection =
	// connectDB.connectDatabase("jdbc:mysql://localhost:3306/pizza_shop", "root",
	// "althaf");

//	String url="jdbc:mysql://localhost:3306/pizza_shop";
//	String DBusername = "root";
//	String DBpassword ="althaf";

	public ArrayList<Order> getOrdersList() {
		ArrayList<Order> list = new ArrayList<>();
		try {
			Connection connection = connectDB.connectDatabase("jdbc:mysql://localhost:3306/pizza_shop", "root",
					"althaf");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("select * from pizza_orders");
			while (resultset.next()) {
				Order order = new Order();
				order.setId(resultset.getInt(1));
				order.setPizzaName(resultset.getString(2));
				order.setPizzaTopping(resultset.getString(3));
				order.setTotalBill(resultset.getInt(4));

				list.add(order);
			}

			connection.close();

			System.out.println(list);
		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return list;
	}

	public ArrayList<Pizzatypes> getPizzas() {
		ArrayList<Pizzatypes> list = new ArrayList<>();

		Connection connection = connectDB.connectDatabase("jdbc:mysql://localhost:3306/pizza_shop", "root", "althaf");

		try {
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM pizzatypes");

			while (resultset.next()) {
				Pizzatypes p1 = new Pizzatypes(resultset.getInt(1), resultset.getString(2), resultset.getInt(3));
				list.add(p1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return list;

	}

	public ArrayList<PizzaToppings> getToppings() {
		ArrayList<PizzaToppings> list = new ArrayList<>();

		try {

			Connection connection = connectDB.connectDatabase("jdbc:mysql://localhost:3306/pizza_shop", "root",
					"althaf");
			Statement statement = connection.createStatement();
			ResultSet resultset = statement.executeQuery("SELECT * FROM pizzatoppings");

			while (resultset.next()) {
				PizzaToppings p1 = new PizzaToppings(resultset.getInt("id"), resultset.getString("Toppings"),
						resultset.getInt("topping_price"));
				list.add(p1);
			}

		} catch (SQLException ex) {
			ex.printStackTrace();
		}

		return list;
	}
	
	
	
	
public void createOrder(int pizzaNameId,int toppingNameId) {
		
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
			
			Connection connection = connectDB.connectDatabase("jdbc:mysql://localhost:3306/pizza_shop", "root",
					"althaf");
			
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
