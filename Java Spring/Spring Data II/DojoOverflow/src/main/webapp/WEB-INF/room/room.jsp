<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${room.name}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
	<h1>Integrantes de la habitación: ${room.name}</h1>
	<form action="/room/${room.id}" method="post">
		<input type="hidden" name="_method" value="put">
		<label>Agregar Estudiante: <select name="user">
					<c:forEach var="alumno" items="${lista}">
							<c:if test="${alumno.room == null}">
        						<option value="${alumno.id}">${alumno.firstName} ${alumno.lastName}</option>
        					</c:if>
   					</c:forEach></select></label>
   		<input type="submit" value="Agregar"/>
   		<a href="/">Volver</a>
   	</form>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Nombre</th>
				<th>Edad</th>
				<th>Acciónes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="alumno" items="${room.students}">
			<tr>
				<td><a href="/students/${alumno.id}">${alumno.firstName} ${alumno.lastName}</a></td>
				<td>${alumno.age}</td>
				<td>
					<form action="/room/${room.id}/${alumno.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Echar"/>
					</form>
				</td>
			</tr>
			</c:forEach>
		</tbody>
	</table>
</div>
</body>
</html>