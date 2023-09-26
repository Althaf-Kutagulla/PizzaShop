<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">
</head>
<body>

<%
	response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
	if(session.getAttribute("username") == null){
		response.sendRedirect("login.jsp");
	}

%>

	
	<form action="Logout">
		<input type="submit" value="logout">
	</form>
	
	<div class="container d-flex justify-content-center">
		<div style="width:100px; height:100px; background-color:red;"><a href="orders.jsp">Orders</a></div>
		<div style="width:100px; height:100px; background-color:yellow;"><a href="about.jsp">about</a></div>
		<div style="width:100px; height:100px; background-color:pink;"><a href="createorder.jsp">Create order</a></div>
		<div style="width:100px; height:100px; background-color:green;"><a href="menu.jsp">Menu</a></div>
	</div>

	
	


</body>
</html>