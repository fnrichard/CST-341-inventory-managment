<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<form:form method="GET" action="/MilestoneProject/home"
	modelAttribute="product">
<h3>Product Listing</h3>
	<table>
		<th>ID</th>
		<th>Name</th>
		<th>Cost</th>
		<th>Amount</th>
		<th>Description</th>
			<c:forEach var = "product" items = "${products}" varStatus="tagStatus">
				<tr>
					<td>${product.ID}</td>
					<td>${product.productName}</td>
					<td>${product.productCost}</td>
					<td>${product.productAmount}</td>
					<td>${product.productDescription}</td>
				</tr>
			</c:forEach>
	</table>
	</form:form>
	
	<form:form method="GET" action="/MilestoneProject/createProduct" modelAttribute="product">
		<input type="submit" value="Create Product"/>
	</form:form>
	
	