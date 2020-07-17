<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Coding Dojo</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
</head>
<body>
  <div class="container">
	<h1>Bienvenido a Coding Dojo</h1>
	<a href="/students">Alumnos</a>
	<a href="/room/new">Nuevo Dormitorio</a>
	<a href="/class/new">Nueva Clase</a>
	<h2>Habitaciones</h2>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Nombre del Dormitorio</th>
				<th>Cantidad de Habitantes</th>
				<th>Acciónes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="room" items="${lugar}">
			<tr>
				<td><a href="/room/${room.id}">${room.name}</a></td>
				<td>${room.students.size()} Habitantes</td>
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
	<h2>Clases</h2>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Nombre de la Clase</th>
				<th>Cantidad de Alumnos</th>
				<th>Acciónes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="sala" items="${clases}">
			<tr>
				<td><a href="/class/${sala.id}">${sala.name}</a></td>
				<td>${sala.students.size()} Estudiantes</td>
				<td>
					<form action="/class/${sala.id}" method="post">
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