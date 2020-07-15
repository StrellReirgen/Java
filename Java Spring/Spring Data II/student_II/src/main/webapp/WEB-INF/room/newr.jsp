<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva habitación</title>
</head>
<body>
	<h2>Nueva habitación</h2>
	<form action="/room/new" method="post">
    	<label>Nombre del Cuarto: <input required="required" type="text" name="room"/></label>
    	<input type="submit" value="Crear"/>
    	<a href="/">Volver</a>
	</form>
</body>
</html>