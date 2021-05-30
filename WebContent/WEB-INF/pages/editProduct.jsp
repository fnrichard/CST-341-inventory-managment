<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h3>Create a new Product</h3>
<form:form method="POST" action="/MilestoneProject/edit" modelAttribute="product">
	<input type="hidden" name="ID" value="${product.ID}" />
	<table>
		<tr>
			<td class="right"><form:label path="productName">Product Name:</form:label></td>
			<td><form:input path="productName" /></td>
			<form:errors path="productName" />
		</tr>
		<tr>
			<td class="right"><form:label path="productCost">Product Cost:</form:label></td>
			<td><form:input path="productCost" /></td>
			<form:errors path="productCost" />
		</tr>
		<tr>
			<td class="right"><form:label path="productAmount">Product Amount:</form:label></td>
			<td><form:input path="productAmount" /></td>
			<form:errors path="productAmount" />
		</tr>
		<tr>
			<td class="right"><form:label path="productDescription">Product Description:</form:label></td>
			<td><form:input path="productDescription" /></td>
			<form:errors path="productDescription" />
		</tr>
		<tr>
			<td colspan="2" class="right"><input type="submit" value="Update" /></td>
		</tr>
		<form:errors path="*" />
	</table>
</form:form>
