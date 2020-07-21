<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Consulta 1</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
</head>
<body>
  <div class="container">
	<h1>Primera Consulta</h1>
	<a href="/">Volver</a>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Country</th>
				<th>Languages</th>
				<th>Languages Percentage</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="pais" items="${lista}">
			<tr>
				<td>${pais.name}</td>
				<td><ul><c:forEach var="leng" items="${pais.languages}"><li>${leng.language}</li></c:forEach></ul></td>
				<td><ul><c:forEach var="leng" items="${pais.languages}"><li>${leng.percentage}</li></c:forEach></ul></td>		
			</tr>
			</c:forEach>
		</tbody>
	</table>
  </div>
</body>
</html>