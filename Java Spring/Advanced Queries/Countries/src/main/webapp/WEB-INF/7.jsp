<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Consulta 7</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
</head>
<body>
  <div class="container">
	<h1>Septima Consulta</h1>
	<a href="/">Volver</a>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Pais</th>
				<th>Ciudad</th>
				<th>Distrito</th>
				<th>Poblacion</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="ciudad" items="${lista.cities}">
			<tr>
				<td>${lista.name}</td>
				<td>${ciudad.name}</td>
				<td>${ciudad.district}</td>
				<td>${ciudad.population}</td>	
			</tr>
			</c:forEach>
		</tbody>
	</table>
  </div>
</body>
</html>