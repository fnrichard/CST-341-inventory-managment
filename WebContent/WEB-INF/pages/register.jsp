<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<h3>User Sign Up</h3>
<form:form method="POST" action="/MilestoneProject/user/confirmUser"
	modelAttribute="user">
	<table>
		<tr>
			<td><form:label path="username">Username:</form:label></td>
			<td><form:input path="username" /></td>
			<form:errors path="username" />
		</tr>
		<tr>
			<td><form:label path="password">Password:</form:label></td>
			<td><form:password path="password" /></td>
			<form:errors path="password" />
		</tr>
		<tr>
			<td><form:label path="email">Email:</form:label></td>
			<td><form:input path="email" /></td>
			<form:errors path="email" />
		</tr>
		<tr>
			<td colspan="2"><input type="submit" value="Submit" /></td>
		</tr>
		<form:errors path="*" />
	</table>
</form:form>