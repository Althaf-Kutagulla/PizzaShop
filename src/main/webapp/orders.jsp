<%@ taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@page import="java.util.ArrayList,com.dataclasses.Pizzatypes,com.databaseoperations.ProductsDao,com.dataclasses.Order" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>
<%
//System.out.println(session.getAttribute("username"));
	//System.out.println(session.getAttribute("password"));
	//Caches
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	//checking login
	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}
	
	ProductsDao orderHistoryList = new ProductsDao();
	ArrayList<Order> orderlist = orderHistoryList.getOrdersList();
	session.setAttribute("orderlist", orderlist);
%>

<table class="table container border">
	<tr>
		<th>Id</th>
		<th>Pizza name</th>
		<th>Pizza topping</th>
		<th>Total Bill</th>
   </tr>  
	
	<c:forEach items="${orderlist}" var="order">
		<tr>
			<td><c:out value="${order.id}"></c:out></td>
			<td><c:out value="${order.pizzaName}"></c:out></td>
			<td><c:out value="${order.pizzaTopping}"></c:out></td>
			<td><c:out value="${order.totalBill}"></c:out></td>
		</tr>
	</c:forEach>
</table>
	

</body>
</html>