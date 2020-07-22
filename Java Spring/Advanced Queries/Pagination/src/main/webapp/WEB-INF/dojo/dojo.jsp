<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${dojo.name}</title>
</head>
<body>
	<h1>Integrantes del Dojo: ${dojo.name}</h1>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Apellido</th>
				<th>Edad</th>
				<th>Acciónes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ninja" items="${dojo.ninjas}">
			<tr>
				<td>>${ninja.firstName}</td>
				<td>${ninja.lastName}</td>	
				<td>${ninja.age}</td>
				<td>
					<form action="/ninja/${ninja.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Borrar"/>
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>