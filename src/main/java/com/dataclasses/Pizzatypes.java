package com.dataclasses;

public class Pizzatypes {
	
	int id;
	String pizzaName;
	int pizzaPrice;
	
	public Pizzatypes() {
		
	}
	
	public Pizzatypes(int id,String pizzaName,int pizzaPrice){
		this.id=id;
		this.pizzaName=pizzaName;
		this.pizzaPrice= pizzaPrice;
	}

	@Override
	public String toString() {
		return "Pizzatypes [id=" + id + ", pizzaName=" + pizzaName + ", pizzaPrice=" + pizzaPrice + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPizzaName() {
		return pizzaName;
	}

	public void setPizzaName(String pizzaName) {
		this.pizzaName = pizzaName;
	}

	public int getPizzaPrice() {
		return pizzaPrice;
	}

	public void setPizzaPrice(int pizzaPrice) {
		this.pizzaPrice = pizzaPrice;
	}
	
	

}
