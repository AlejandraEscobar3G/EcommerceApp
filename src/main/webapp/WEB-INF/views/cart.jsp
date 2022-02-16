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
			<td>Price</td>
			<td>Quantity</td>
			<td>Subtotal</td>
		</tr>
		<c:forEach items="${cartList}" var="item">
			<tr>
				<td>${ item.productName }</td>
				<td>${ item.productPrice }</td>
				<td>${ item.productQuantity }</td>
				<td>${ item.productSubtotal }</td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="4">Total ${total}</td>
		</tr>
		<tr>
			<td><a href="/app/purchase/${ userId }">Pay</a></td>
		</tr>
	</table>
</body>
</html>