<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products List</title>
</head>
<body>
	<h1>Products List</h1>
	<div align="center">
		<form:form action="addToCart" method="post" modelAttribute="product">
			<table>
				<tr>
					<th>Product Name</th>
					<th>Product Category</th>
					<th>Price</th>
					<th>Available Quantity</th>
				</tr>
				<c:forEach items="${productsList}" var="prod">
					<tr>
						<td>${ prod.productName }</td>
						<td>${ prod.productCategory }</td>
						<td>${ prod.productPrice }</td>
						<td>${ prod.productQuantity }</td>
						<td><input type="submit" value="Add to cart"/></td>
					</tr>
				</c:forEach>
				<tr>
					<td><a href="viewCart/${ userId }">View cart</a></td>
				</tr>
			</table>
		</form:form>
	</div>
</body>
</html>