<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page import="com.gcu.main.Cashe"%>
<div class="logo">
	Product Manager
</div>

<div class="head-data">
	<div class="logged-in">
		Logged in as: <% out.print(Cashe.getLoggedUser().getUsername()); %>
		<% if (Cashe.loggedUser.getUsername().equals("Not Logged In") == false) {%>
			<a href="/MilestoneProject/logout">Logout</a>
		<%}%>
	</div>
		
	<div class="menu">
		<% if (Cashe.loggedUser.getUsername().equals("Not Logged In")) {%>
		    <a href="/MilestoneProject/login">Login</a>
			<a href="/MilestoneProject/user/register">Register</a>
		<%} else { %>
			<a href="/MilestoneProject/home">Home</a>
		<%}%>
	</div>
</div>