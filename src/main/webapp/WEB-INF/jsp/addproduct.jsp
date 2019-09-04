<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page session="false"%>
<html>
<head>
<title>Category page</title>
</head>
<body>
	<h3>Please provide the PRODUCT ID below and press 'Buy Product for ID' button</h3>

	<form action="client/getproductbyid" method="get">
		Product ID : <input type="text" name="id"><br> 
					<input type="submit" value="Buy Product for ID">
	</form>
</body>
</html>