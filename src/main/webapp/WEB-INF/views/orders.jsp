<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Orders</title>
</head>
<body>
	<h1>Your orders</h1>
	<table>
		<tr>
			<td>Order reference</td>
			<td>date</td>
			<td>Total</td>
		</tr>
		<c:forEach items="${ordersList}" var="item">
			<tr>
				<td>${ item.orderId }</td>
				<td>${ item.orderDate }</td>
				<td>${ item.total }</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>