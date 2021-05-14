<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Please Login</h3>
<form:form method="POST" action="/MilestoneProject/login"
	modelAttribute="user">
	<c:if test="${not empty user.username}">
		<div style="color: red;">
    		Login or password is incorrect.
    	</div>
	</c:if>
	<table>
        <tr>
			<td><form:label path="username">Username</form:label></td>
			<td>
				<form:input path="username"/>
			</td>
		</tr>
		<tr>
			<td><form:label path="password">Password</form:label></td>
			<td>
				<form:password path="password"/>	
			</td>
		</tr>
        <tr>
        	<td>&nbsp;</td>
			<td style="text-align: right;"><input type="submit" value="Submit"/></td>
		</tr>
	</table>
</form:form>