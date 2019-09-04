<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<form method="get" action="employee/assignevent">
		<center>
			<table class="table1">
				<thead>
					<tr>
						<th><a href="event/allevents">Click Here to List all
								available Events </a></th>
						<th><a href="employee/allemployees">Click Here to List
								all Employees </a></th>
					</tr>
				</thead>
			</table>
			<c:if test="${not empty norecord}">
				<c:forEach var="o" items="${norecord}">
					<tr>
						<td>${o}</td>
					</tr>
				</c:forEach>
			</c:if>
			<table class="table1">
			
				<tr>
					<th>Register Event for Employee</th>
				</tr>

				<tbody>
					<tr>
						<td>Employee ID</td>
						<td><c:if test="${not empty allemployees}">
								<select name="employeeId">

									<c:forEach var="al" items="${allemployees}">

										<option value=${al.mid}>${al.mid}</option>

									</c:forEach>

								</select>
							</c:if></td>
					</tr>
					<tr>
						<td>Select Event to register for Employee</td>
						<td><c:if test="${not empty allevents}">
								<select name="eventId">

									<c:forEach var="ale" items="${allevents}">

										<option value=${ale.eventId}>${ale.eventId}</option>

									</c:forEach>

								</select>
							</c:if></td>
					</tr>

				</tbody>

				<tr>
					<td></td>
					<td><input type="reset" value="Reset" /><input type="submit"
						value="Register" /></td>
				</tr>

			</table>
			<!-- 			<table class="table1">
				<thead>
					<tr>
			<td><a href="emp" class="button">Click here to create new Employee</a></td>&nbsp &nbsp &nbsp
			<td><a href="evnt" class="button">Click here to create new Event</a></td>&nbsp &nbsp &nbsp
			<td><a href="deregister" class="button">Click here to De-Register Event</a></td> &nbsp &nbsp
			<td><a href="deleteevent" class="button">Click here to delete Event</a></td><br/> &nbsp &nbsp
			<td><a href="deleteemp" class="button">Click here to delete Employee</a></td><br/> &nbsp &nbsp
					</tr>
				</thead>
			</table> -->
			<a href="emp" class="button">Click here to create new Employee</a>
			&nbsp; &nbsp; 
			<a href="evnt" class="button">Click here to create new Event</a>
			 &nbsp; &nbsp; 
			 <a href="deregister" class="button">Click here to De-Register Event</a>
			  &nbsp; &nbsp; 
			 <a href="deleteevent"class="button">Click here to delete Event</a>
			  &nbsp; &nbsp; 
			  <a href="deleteemp" class="button">Click here to delete Employee</a>
			&nbsp; &nbsp;
		</center>
	</form>
</body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Welcome to Event Registration</title>
<style>
table.table1 {
	font-family: "Trebuchet MS", sans-serif;
	font-size: 16px;
	font-weight: bold;
	line-height: 1.4em;
	font-style: normal;
	border-collapse: separate;
}

.table1 thead th {
	padding: 15px;
	color: #fff;
	text-shadow: 1px 1px 1px #568F23;
	border: 1px solid #93CE37;
	border-bottom: 3px solid #9ED929;
	background-color: #9DD929;
	background: -webkit-gradient(linear, left bottom, left top, color-stop(0.02, rgb(123
		, 192, 67)), color-stop(0.51, rgb(139, 198, 66)),
		color-stop(0.87, rgb(158, 217, 41)));
	background: -moz-linear-gradient(center bottom, rgb(123, 192, 67) 2%,
		rgb(139, 198, 66) 51%, rgb(158, 217, 41) 87%);
	-webkit-border-top-left-radius: 5px;
	-webkit-border-top-right-radius: 5px;
	-moz-border-radius: 5px 5px 0px 0px;
	border-top-left-radius: 5px;
	border-top-right-radius: 5px;
}

.table1 thead th:empty {
	background: transparent;
	border: none;
}

.table1 tfoot td {
	color: #9CD009;
	font-size: 32px;
	text-align: center;
	padding: 10px 0px;
	text-shadow: 1px 1px 1px #444;
}

.table1 tfoot th {
	color: #666;
}

.table1 tbody td {
	padding: 10px;
	text-align: center;
	background-color: #DEF3CA;
	border: 2px solid #E7EFE0;
	-moz-border-radius: 2px;
	-webkit-border-radius: 2px;
	border-radius: 2px;
	color: #666;
	text-shadow: 1px 1px 1px #fff;
}

.button {
	font: bold 11px Arial;
	text-decoration: none;
	background-color: #EEEEEE;
	color: #333333;
	padding: 2px 6px 2px 6px;
	border-top: 1px solid #CCCCCC;
	border-right: 1px solid #333333;
	border-bottom: 1px solid #333333;
	border-left: 1px solid #CCCCCC;
}
</style>
</head>
</html>