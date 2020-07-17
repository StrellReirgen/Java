<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Lista de Estudiantes</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
  <div class="container">
	<h1>Estudiantes del Coding Dojo</h1>
	<a href="/students/new">Nuevo Alumno</a>
	<a href="/contact/new">Agregar Datos de Contacto</a>
	<a href="/">Volver</a>
	<table class="table table-striped table-hover table-bordered">
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
				<td><a href="/students/${alumno.id}">${alumno.firstName} ${alumno.lastName}</a></td>
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
  </div>
</body>
</html>