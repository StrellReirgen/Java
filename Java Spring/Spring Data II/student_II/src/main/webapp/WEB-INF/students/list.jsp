<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lista de Estudiantes</title>
</head>
<body>
	<h1>Estudiantes del Coding Dojo</h1>
	<a href="/students/new">Nuevo Alumno</a>
	<a href="/contact/new">Agregar Datos de Contacto</a>
	<a href="/">Volver</a>
	<table>
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Dirección</th>
				<th>Ciudad</th>
				<th>Estado</th>
				<th>Acciónes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="alumno" items="${lista}">
			<tr>
				<td>${alumno.firstName} ${alumno.lastName}</td>
				<td>${alumno.age}</td>	
				<td>${alumno.contact.address}</td>
				<td>${alumno.contact.city}</td>
				<td>${alumno.contact.state}</td>
				<td>
					<form action="/student/${alumno.id}" method="post">
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