<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tabla de Preguntas</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
</head>
<body>
  <div class="container">
	<h1>Tabla de Preguntas</h1>
	<a href="/questions/new">Nueva Pregunta</a>
	<table class="table table-striped table-hover table-bordered">
		<thead>
			<tr>
				<th>Preguntas</th>
				<th>Etiquetas</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="quest" items="${items}">
			<tr>
				<td><a href="/questions/${quest.id}">${quest.question}</a></td>
				<td><c:forEach var="eti" items="${quest.tags}">${eti.subject} </c:forEach></td>		
			</tr>
			</c:forEach>
		</tbody>
	</table>
  </div>
</body>
</html>