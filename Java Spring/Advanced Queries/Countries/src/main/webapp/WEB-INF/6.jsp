<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Consulta 6</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
</head>
<body>
  <div class="container">
	<h1>Sexta Consulta</h1>
	<a href="/">Volver</a>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Pais</th>
				<th>Gobierno</th>
				<th>Superficie</th>
				<th>Poblacion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pais" items="${lista}">
			<tr>
				<td>${pais.name}</td>
				<td>${pais.governmentForm}</td>
				<td>${pais.surfaceArea}</td>
				<td>${pais.population}</td>	
			</tr>
			</c:forEach>
		</tbody>
	</table>
  </div>
</body>
</html>