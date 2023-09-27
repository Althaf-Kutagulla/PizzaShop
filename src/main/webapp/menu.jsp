<%@ page import="com.databaseoperations.ProductsDao,java.util.ArrayList,com.dataclasses.Pizzatypes,com.dataclasses.PizzaToppings" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Menu</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

	<%
	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}
	
	ProductsDao products = new ProductsDao();
	ArrayList<Pizzatypes> pizzaList =products.getPizzas();
	session.setAttribute("pizzaList", pizzaList);
	ArrayList<PizzaToppings> toppingList = products.getToppings();
	session.setAttribute("toppingList", toppingList);
	%>
	
	<table class="table">
	
		<tr>
			<th>Pizza Name</th>
			<th>Price</th>
		</tr>
		
		<c:forEach items="${pizzaList}" var="pizza">
			<tr>
				<td><c:out value="${pizza.pizzaName}"></c:out></td>
				<td><c:out value="${pizza.pizzaPrice}"></c:out></td>
			</tr>
		</c:forEach>
		
		
	</table>
	
	<table class="table">
	
		<tr>
			<th>Topping Name</th>
			<th>Price</th>
		</tr>
		
		<c:forEach items="${toppingList}" var="topping">
			<tr>
				<td><c:out value="${topping.topping}"></c:out></td>
				<td><c:out value="${topping.price}"></c:out></td>
			</tr>
		</c:forEach>
		
		
	</table>
	
</body>
</html>