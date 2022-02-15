<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Cart</title>
</head>
<body>
	<h1>Your cart</h1>
	<table>
		<tr>
			<td>Product</td>
			<td>Quantity</td>
		</tr>
		<c:forEach items="${cartList}" var="item">
			<tr>
				<td>${ item.productId }</td>
				<td>${ item.quantity }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>