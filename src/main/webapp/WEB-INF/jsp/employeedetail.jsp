<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<body>
	<form method="get" action="employee/deleteregistedevent">
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
			<c:if test="${not empty employee}">
				<table class="table1">
					<thead>
						<tr>
							<th scope="col" abbr="id">Employee Id</th>
							<th scope="col" abbr="name">Employee Name</th>
							<th scope="col" abbr="join">Joining Date</th>
							<th scope="col" abbr="email">Email Id</th>
							<th scope="col" abbr="events">Registered Events</th>
						</tr>
					</thead>
					<tbody>
						<tr>
							<td><input type="hidden" value=${employee.mid} name="employeeId"/> ${employee.mid}</td>
							<!-- <input type="checkbox" value=${eventMap.key} name="eventId"/> -->
							<td>${employee.name}</td>
							<td>${employee.joinDate}</td>
							<td>${employee.emailId}</td>
							<td>
								<table class="table1">
									<thead>
										<tr>
											<th scope="col" abbr="id">Event ID</th>
											<th scope="col" abbr="name">Event Details</th>
										</tr>
									</thead>
									<c:forEach var="eventMap" items="${employee.registerdevents}">
										<tr>
											<td><input type="checkbox" value=${eventMap.key} name="eventId"/> ${eventMap.key}</td>
											<td>
												<table class="table1">
													<thead>
														<tr>
															<th scope="col" abbr="title">Event Title</th>
															<th scope="col" abbr="description">Event Description</th>
														</tr>
													</thead>
													<tr>
														<td>${eventMap.value.eventTitle}</td>
														<td>${eventMap.value.description}</td>
													</tr>
												</table>
											</td>

										</tr>
									</c:forEach>
								</table>
							</td>

						</tr>
					</tbody>
					<tfoot>
						<tr>
							<td></td> <td></td> <td></td> <td></td>
							<td>
								<input type="submit" value="De-register selected Event">
							</td>
						</tr>
					</tfoot>
				</table>
			</c:if>
		</center>
	</form>
</body>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Employees Details</title>
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
</style>
</head>
</html>