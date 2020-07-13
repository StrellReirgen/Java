<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personas y sus Licencias</title>
</head>
<body>
	<h1>Information</h1>
	<table>
		<thead>
			<th>First Name</th>
			<th>Last Name</th>
			<th>License #</th>
			<th>State</th>
			<th>Expiration Date</th>
		</thead>
		<tbody>
			<c:forEach var="person" items="${people}">
			<tr>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.license.number}</td>
				<td>${person.license.state}</td>
				<td>${person.license.expirationDate}</td>				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>