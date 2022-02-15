<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form:form action="login" method="post" modelAttribute="credential">
		<table style="width:80%">
			<tr>
				<td>User name:</td>
				<td><form:input path="name" /></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Login"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>