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
		<table>
			<tr>
				<th>Product Name</th>
				<th>Product Category</th>
				<th>Price</th>
				<th>Available Quantity</th>
			</tr>
			<c:forEach items="${productsList}" var="prod">
				<tr>
					<form:form action="addToCart" method="post" modelAttribute="product">
						<input path="productId" name="productId" type="hidden" value="${prod.productId}">
	                    <input path="productName" name="productName" type="hidden" value="${prod.productName}">
	                    <input path="productCategory" name="category" type="hidden" value="${prod.productCategory}">
	                    <input path="productPrice" name="price" type="hidden" value="${prod.productPrice}">
	                    <input path="productQuantity"  name="producQuantity" type="hidden" value="${prod.productQuantity}">
	                    
	                    <td>${prod.productName}</td> 
	                    <td>${prod.productCategory}</td>
	                    <td>${prod.productPrice}</td>
	                    <td>${prod.productQuantity}</td>
	                    <td><input type="submit" value="add to cart"></td>
					</form:form>
				</tr>
			</c:forEach>
			<tr>
				<td><a href="viewCart/${ userId }">View cart</a></td>
			</tr>
		</table>
	</div>
</body>
</html>