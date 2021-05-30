<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<h3>Create a new Product</h3>
<form:form method="POST" action="/MilestoneProject/delete"
	modelAttribute="product">
	<input type="hidden" name="id" value="${product.ID}" />
	Are you sure you want to delete ${product.productName} <br />
	<input type="button" onclick="void(window.location = '/MilestoneProject/home')" value="No" />
	<input type="submit" value="Yes" />
</form:form>


