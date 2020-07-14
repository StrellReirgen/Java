<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Personas y sus Licencias</title>
</head>
<body>
	<h1>Información</h1>
	<a href="/persons/new">Nueva Persona</a>
	<a href="/licenses/new">Nueva Licencia</a>
	<table>
		<thead>
			<tr>
				<th>R.U.N.</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>License #</th>
				<th>State</th>
				<th>Expiration Date</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="person" items="${user}">
			<tr>
				<td><a href="/persons/${person.id}">${person.rut}</a></td>
				<td>${person.firstName}</td>
				<td>${person.lastName}</td>
				<td>${person.license.number}</td>
				<td>${person.license.state}</td>
				<td><fmt:formatDate pattern ="dd-MM-yyyy" value = "${person.license.expirationDate}" /></td>				
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>