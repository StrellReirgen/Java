<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Coding Dojo</title>
</head>
<body>
	<h1>Bienvenido a Coding Dojo</h1>
	<a href="/students">Alumnos</a>
	<a href="/room/new">Nuevo Dormitorio</a>
	<table>
		<thead>
			<tr>
				<th>Nombre del Dojo</th>
				<th>Cantidad de alumnos</th>
				<th>Acciónes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="room" items="${lugar}">
			<tr>
				<td><a href="/room/${room.id}">${room.name}</a></td>
				<td>${room.students.size()} Estudiantes</td>
				<td>
					<form action="/room/${room.id}" method="post">
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