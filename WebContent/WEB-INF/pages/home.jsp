<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script>
	// script tag added by Richard
	// retrieved from https://stackoverflow.com/questions/901115/how-can-i-get-query-string-values-in-javascript
	function getParameterByName(name, url = window.location.href) {
	    name = name.replace(/[\[\]]/g, '\\$&');
	    const regex = new RegExp('[?&]' + name + '(=([^&#]*)|&|#|$)'), results = regex.exec(url);
	    if (!results) return null;
	    if (!results[2]) return '';
	    return decodeURIComponent(results[2].replace(/\+/g, ' '));
	}
	window.onload = function() {
		try {
			const query = getParameterByName('query');
			if (query) {
				document.getElementById('query').value = query;
			}
		} catch (e) {
			// do nothing but twittle thumbs and ignore... this is fine
		}
	}
</script>

<h3>Product Listing</h3>

<form:form method="GET" action="/MilestoneProject/search">
	<input type="text" id="query" name="query" />
	<input type="submit" value="Search Products"/>
</form:form>

<form:form method="GET" action="/MilestoneProject/home" modelAttribute="product">
	<table>
		<th>ID</th>
		<th>Name</th>
		<th>Cost</th>
		<th>Amount</th>
		<th>Description</th>
		<th></th>
		<th></th>
			<c:forEach var = "product" items = "${products}" varStatus="tagStatus">
				<tr>
					<td>${product.ID}</td>
					<td>${product.productName}</td>
					<td>${product.productCost}</td>
					<td>${product.productAmount}</td>
					<td>${product.productDescription}</td>
					<td><a href="/MilestoneProject/delete?id=${product.ID}">Delete</a></td>
					<td><a href="/MilestoneProject/edit?id=${product.ID}">Edit</a></td>
				</tr>
			</c:forEach>
	</table>
	</form:form>
	
	<form:form method="GET" action="/MilestoneProject/createProduct" modelAttribute="product">
		<input type="submit" value="Create Product"/>
	</form:form>
	
	