<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Category page</title>
</head>
<body>
	<h3>Please provide the cetagory below and press 'Get Product by category' button</h3>

	<form action="client/getproducts" method="get">
		<input type="text" name="category"><br> <input
			type="submit" value="Get Product by category">
	</form>
</body>
</html>