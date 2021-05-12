<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<head>
<%@ page import="com.gcu.main.Cashe" %>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Product Manger</title>
</head>

<body>

	<h1>Thank you for choosing Product Manager !</h1>
	
	<% if (Cashe.loggedUser.getUsername().equals("Not Logged In")) {
	%>
	<h2>Existing users</h2>
	<form:form method="GET" action="/MilestoneProject/login"
		modelAttribute="user">
		<input type="submit" value="Login" />
	</form:form>
	
	<h2>New customers</h2>
	<form:form method="GET" action="/MilestoneProject/user/register"
		modelAttribute="user">
		<input type="submit" value="Register" />
	</form:form>
	
	<%} else { %>
	<h2>Home Page</h2>
	<form:form method="GET" action="/MilestoneProject/home"
		modelAttribute="product">
		<input type="submit" value="home" />
	</form:form>
	
	<%}%>
	
	


	
	
	
	
	

</body>

</html>