<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

<script>
	// script tag added by Richard
	function setLoading() {
		$('#products').html("<tr><td colspan='6'>Loading...</td></tr>");
	}
	
	function getProducts() {
		setLoading();
		$.get('/MilestoneProject/products', function(data, status) {
			buildTableWithProducts(data);
		});
	}
	
	function buildTableWithProducts(products) {
		let html = "";
		if (!products || !products.length) {
			html = "<tr><td colspan='6'>No entries found</td></tr>";	
		} else {
			products.forEach(function(product) { 
				html += "<tr>"
					  + "	<td>" + product.id + "</td>"
				      + "	<td>" + product.productName + "</td>"
				      + "	<td>" + product.productCost + "</td>"
				      + "	<td>" + product.productAmount + "</td>"
				      + "	<td>" + product.productDescription + "</td>"
				      + "	<td>"
				      + "	    <a href='/MilestoneProject/edit?id=" + product.id + "'>Edit</a> | "
				      + "       <a href='/MilestoneProject/delete?id=" + product.id + "'>Delete</a>"
				      + "   </td>"
				      + "</tr>";
			});
		}
		$('#products').html(html);
	}
	
	
	$(function() { // window onload
		let queryLastValue = "";
		$('#search-button').click(function() { // button click
			setLoading();
			const query = $('#query').val();
			queryLastValue = query;
			$.get('/MilestoneProject/search?query=' + query, function(data, status) {
				buildTableWithProducts(data);
			});
		});
	
		$('#query').blur(function() {
			const query = $('#query').val();
			if (query === "" && queryLastValue !== query) {
				queryLastValue = query;
				getProducts();
			}
		});
	
		// load all products
		getProducts();
	});
</script>

<h3>Product Listing</h3>

<div style="margin-bottom: 0.4rem">
	<input type="text" id="query" name="query" />
	<input type="button" id="search-button" value="Search Products" />
</div>

<form:form method="GET" action="/MilestoneProject/home" modelAttribute="product">
	<table>
		<thead>
			<tr>
				<th>ID</th>
				<th>Name</th>
				<th>Cost</th>
				<th>Amount</th>
				<th>Description</th>
				<th>Actions</th>
			</tr>
		</thead>
		<tbody id="products">
			<tr>
				<td colspan="6">Loading...</td>
			</tr>
		</tbody>
	</table>
	</form:form>
	
	<form:form method="GET" action="/MilestoneProject/createProduct" modelAttribute="product">
		<input type="submit" value="Create Product"/>
	</form:form>
	
	