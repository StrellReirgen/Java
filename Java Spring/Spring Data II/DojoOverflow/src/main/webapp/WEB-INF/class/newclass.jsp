<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nueva Clases</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<h2>Nueva Clase</h2>
	<form action="/class/new" method="post">
		<div class="form-group">
    	<label>Nombre de la Materia: <input required="required" type="text" name="class" class="form-control"/></label>
    	</div>
    	<input type="submit" value="Crear"/>
    	<a href="/">Volver</a>
	</form>
	</div>
</body>
</html>