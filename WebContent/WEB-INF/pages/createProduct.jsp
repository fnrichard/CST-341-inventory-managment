<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h3>Create a new Product</h3>
<form:form method="POST" action="/MilestoneProject/createProduct"
	modelAttribute="product">
	<table>
		<tr>
			<td><form:label path="productName">Product Name:</form:label></td>
			<td><form:input path="productName" /></td>
			<form:errors path="productName" />
		</tr>
		<tr>
			<td><form:label path="productCost">Product Cost:</form:label></td>
			<td><form:input path="productCost" /></td>
			<form:errors path="productCost" />
		</tr>
		<tr>
			<td><form:label path="productAmount">Product Amount:</form:label></td>
			<td><form:input path="productAmount" /></td>
			<form:errors path="productAmount" />
		</tr>
		<tr>
			<td><form:label path="productDescription">Product Description:</form:label></td>
			<td><form:input path="productDescription" /></td>
			<form:errors path="productDescription" />
		</tr>
		<tr>
			<td colspan="2" style="text-align: right;"><input type="submit" value="Create" /></td>
		</tr>
		<form:errors path="*" />
	</table>
</form:form>
