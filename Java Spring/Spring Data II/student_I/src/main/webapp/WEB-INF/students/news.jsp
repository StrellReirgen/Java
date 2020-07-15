<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Estudiante</title>
</head>
<body>
	<h2>Nuevo Estudiante</h2>
	<form action="/students/new" method="post">
    	<label>Nombre: <input required="required" type="text" name="name"/></label>
        <label>Apellido: <input type="text" name="lastname" required="required"/></label>
        <label>Edad: <input type="number" name="age" required="required"/></label> 
    	<input type="submit" value="Crear"/>
    	<a href="/students">Volver</a>
	</form>
</body>
</html>