<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nuevo Estudiante</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	
</head>
<body>
	<div class="container">
	<h2>Nuevo Estudiante</h2>
	<form action="/students/new" method="post">
	  <div class="form-group">
    	<label>Nombre: <input required="required" type="text" name="name" class="form-control"/></label>
      </div>
      <div class="form-group">
        <label>Apellido: <input type="text" name="lastname" required="required" class="form-control"/></label>
      </div>
      <div class="form-group">
        <label>Edad: <input type="number" name="age" required="required" class="form-control"/></label>
      </div>
    	<input type="submit" value="Crear"/>
    	<a href="/students">Volver</a>
	</form>
	</div>
</body>
</html>