<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.gcu.main.Cashe"%>
<div align="center">
	<h1>Product Manager</h1>
</div>
<div align="right">
	Logged in as: <% out.print(Cashe.getLoggedUser().getUsername()); %>
</div>

<div align="left">

<% if (Cashe.loggedUser.getUsername().equals("Not Logged In")) {
	%>
	<form:form method="GET" action="/MilestoneProject/login"
		modelAttribute="user">
		<input type="submit" value="Login" />
	</form:form>
	
	<form:form method="GET" action="/MilestoneProject/user/register"
		modelAttribute="user">
		<input type="submit" value="Register" />
	</form:form>
	
	<%} else { %>
	<form:form method="GET" action="/MilestoneProject/home"
		modelAttribute="product">
		<input type="submit" value="home" />
	</form:form>
	
	<%}%>



</div>

<hr>