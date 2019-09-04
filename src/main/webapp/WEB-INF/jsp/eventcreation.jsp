<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<body>
	<form method="get" action="/event/save">
		<center>
			<c:if test="${not empty error}">
				<c:forEach var="o" items="${error}">
					<tr>
						<td>${o}</td>
					</tr>
				</c:forEach>
			</c:if>

			<c:if test="${not empty success}">
				<c:forEach var="o" items="${success}">
					<tr>
						<td><h3>${success}</h3></td>
					</tr>
				</c:forEach>
			</c:if>
			
			<c:if test="${not empty allreadyexist}">
				<c:forEach var="o" items="${allreadyexist}">
					<tr>
						<td>${o}</td>
					</tr>
				</c:forEach>
			</c:if>
			
			<table class="table1">
				<thead>
					<tr>
						<th><a href="/ERS-1.0/index">Click Here return to Home Page </a></th>
					</tr>
				</thead>
				</table>

		</center>
	</form>
</body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Event Registration</title>
</head>
</html>