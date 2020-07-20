<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nueva Pregunta</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h2>¿Cual es tu Pregunta?</h2>
		<form action="/questions/new" method="post">
			<div class="form-group">
	    		<label>Pregunta: <textarea required="required" name="quest" class="form-control" rows="6" cols="500"></textarea></label>
	    	</div>
	    	<div class="form-group">
	    		<label>Tags: <input required="required" type="text" name="tag" class="form-control"/></label>
	    		<p class="text-danger">${errors}</p>
	    	</div>
	    	<input type="submit" value="Crear"/>
	    	<a href="/questions">Volver</a>
		</form>
	</div>
</body>
</html>