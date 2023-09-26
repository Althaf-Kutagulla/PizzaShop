<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"
	import="com.databaseoperations.LoginDao,com.databaseoperations.Pizza,com.dataclasses.Pizzatypes,java.util.ArrayList,com.dataclasses.PizzaToppings"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN"
	crossorigin="anonymous">
</head>
<body>

	<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}
	Pizza pizzas = new Pizza();
	ArrayList<Pizzatypes> list = pizzas.getPizzas();
	session.setAttribute("pizzasList", list);
	for (int i = 0; i < list.size(); i++) {
		System.out.println(list.get(i).getPizzaName());
	}

	ArrayList<PizzaToppings> toppingsList = pizzas.getToppings();
	session.setAttribute("pizzaToppingsList", toppingsList);
	for (PizzaToppings p1 : toppingsList) {
		System.out.println(p1.getTopping());
	}
	%>




	<h1 class="text-align-centre">Create Order</h1>

	<form class="container" action="ConfirmOrder" method="post">
		<select class="form-select" aria-label="Default select example"
			name="pizza">
			<option selected>Select Pizza</option>
			<c:forEach items="${pizzasList}" var="pizza">
				<option value="${pizza.id}">${pizza.pizzaName}</option>
			</c:forEach>
		</select> <select class="form-select" aria-label="Default select example"
			name="topping">
			<option selected>Select Topping</option>
			<c:forEach items="${pizzaToppingsList}" var="topping">
				<option value="${topping.id}">${topping.topping }</option>
			</c:forEach>
		</select>
		<button type="submit" class="btn btn-primary">Place Order</button>
	</form>


	<c:forEach items="${pizzaslist}" var="pizza">
		<c:out value="${pizza}">not working</c:out>
	</c:forEach>

	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
		crossorigin="anonymous"></script>
</body>
</html>