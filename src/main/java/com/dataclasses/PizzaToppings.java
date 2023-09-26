package com.dataclasses;

public class PizzaToppings {
	
	int id;
	String topping;
	int price;
	
	public PizzaToppings(){
		
	}
	
	public PizzaToppings(int id,String topping,int price){
		
		this.id=id;
		this.topping=topping;
		this.price=price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTopping() {
		return topping;
	}

	public void setTopping(String topping) {
		this.topping = topping;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
	
	

}
