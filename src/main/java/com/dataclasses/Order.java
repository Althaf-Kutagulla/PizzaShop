package com.dataclasses;

public class Order {
	int id;
	String pizzaName;
	String pizzaTopping;
	int totalBill;
	
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
	@Override
	public String toString() {
		return "OrderDao [id=" + id + ", pizzaName=" + pizzaName + ", pizzaTopping=" + pizzaTopping + ", totalBill="
				+ totalBill + "]";
	}
	public String getPizzaTopping() {
		return pizzaTopping;
	}
	public void setPizzaTopping(String pizzaTopping) {
		this.pizzaTopping = pizzaTopping;
	}
	public int getTotalBill() {
		return totalBill;
	}
	public void setTotalBill(int totalBill) {
		this.totalBill = totalBill;
	}
	
	
}
