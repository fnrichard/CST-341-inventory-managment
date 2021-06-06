<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>CST-341 In-Class Activity</title>
	<script
		src="https://code.jquery.com/jquery-3.6.0.min.js"
		integrity="sha256-/xUj+3OJU5yExlq6GSYGSHk7tPXikynS7ogEvDej/m4="
		crossorigin="anonymous"></script>
	<spring:url value="/resources/css/main.css" var="mainCss" />
	<spring:url value="/resources/js/main.js" var="mainJs" />
	
	<link href="${mainCss}" rel="stylesheet" />
	<script src="${mainJs}"></script>
</head>

<body>
	<!-- Header -->
	<div class="header">
		<tiles:insertAttribute name="header" />
	</div>
	
	<!-- Body Page -->
	<div class="body" align="center">
		<tiles:insertAttribute name="body" />
	</div>
	
	<!-- Footer Page -->
	<div class="footer">
		<tiles:insertAttribute name="footer" />
	</div>
</body>

</html>