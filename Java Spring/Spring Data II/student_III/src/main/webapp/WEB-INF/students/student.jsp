<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${alumno.firstName} ${alumno.lastName}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<a href="/students">Volver</a>
		<h1>${alumno.firstName} ${alumno.lastName}</h1>
		<h3>Sus Clases</h3>
		<ul>
			<c:forEach items="${alumno.classes}" var="clase">
				<li><a href="/class/${clase.id}">${clase.name}</a></li>
			</c:forEach>
		</ul>
		<c:if test="${!empty clases}">
		<h3>Inscribir a una Clase</h3>
		<form action="/students/${alumno.id}" method="POST">
			<div class="form-group">
				<label>Clases:</label>
				<select name="clase">
					<c:forEach items="${clases}" var="clas">
        					<option value="${clas.id}">${clas.name}</option>
   					</c:forEach>
				</select>
			</div>
			<input type="submit" value="Inscribir a esta Clase" class="btn btn-default">
		</form>
		</c:if>
	</div>
</body>
</html>