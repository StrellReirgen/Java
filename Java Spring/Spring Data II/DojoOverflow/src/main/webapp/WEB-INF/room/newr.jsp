<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nueva habitación</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
<div class="container">
	<h2>Nueva habitación</h2>
	<form action="/room/new" method="post">
		<div class="form-group">
    	<label>Nombre del Cuarto: <input required="required" type="text" name="room" class="form-control"/></label>
    	</div>
    	<input type="submit" value="Crear"/>
    	<a href="/">Volver</a>
	</form>
	</div>
</body>
</html>