<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Pregunta N° ${item.id}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>${item.question}</h1>
		<h2>Tags: <c:forEach var="eti" items="${item.tags}"><span class="border border-primary rounded">${eti.subject} </span></c:forEach></h2>
		<div class="container">
			<h2>Agrega tu respuesta:</h2>
			<form action="/questions/${item.id}" method="post">
				<div class="form-group">
		    	<label>Respuesta: <textarea required="required" name="answer" class="form-control" rows="4" cols="500"></textarea></label>
		    	</div>
		    	<input type="submit" value="Crear"/>
		    	<a href="/questions">Volver</a>
			</form>
		</div>
		<div class="container">
			<table class="table table-striped table-hover table-bordered">
				<thead>
					<tr>
						<th>Respuestas</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="resp" items="${item.answers}">
					<tr>
						<td>${resp.answer}</td>		
					</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
	</div>
</body>
</html>