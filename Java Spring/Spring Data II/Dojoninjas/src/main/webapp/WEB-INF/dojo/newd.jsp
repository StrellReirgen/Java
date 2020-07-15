<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Dojo</title>
</head>
<body>
	<h2>Nuevo Dojo</h2>
	<form action="/dojo/new" method="post">
    	<label>Nombre del Dojo: <input required="required" type="text" name="dojo"/></label>
    	<input type="submit" value="Crear"/>
    	<a href="/">Volver</a>
	</form>
</body>
</html>