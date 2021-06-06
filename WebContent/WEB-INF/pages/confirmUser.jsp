<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>Confirm Account:</h3>
<form:form method="POST" action="/MilestoneProject/login"
	modelAttribute="user">
<table>
	<th>Username: ${user.username}</th>
	<th>Password: ${user.password}</th>
	<th>Email: ${user.email}</th>
	<tr>
		<td colspan="2"><input type="submit" value="Login"/></td>
	</tr>
</table>
</form:form>