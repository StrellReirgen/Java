<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${clase.name}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<a href="/">Volver</a>
		<h1>${clase.name}</h1>
		<h3>Alumnos en esta Clase</h3>
		<ul>
			<c:forEach items="${clase.students}" var="alumno">
				<li><a href="/students/${alumno.id}">${alumno.firstName} ${alumno.lastName}</a></li>
			</c:forEach>
		</ul>
	</div>
</body>
</html>