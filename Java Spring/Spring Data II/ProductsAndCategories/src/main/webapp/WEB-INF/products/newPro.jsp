<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nuevo Producto</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">

</head>
<body>
	<div class="container">
	<h1>Nuevo Producto</h1>
	<a href="/">Home</a> | <a href="/categories/new">Agregar una Categoria</a>
	<form action="/products/new" method="post">
		<div class="form-group">
    		<label>Nombre: <input class="form-control" required="required" type="text" name="name"/></label>
    		<p class="text-danger">${errorsA}</p>
        </div>
        <div class="form-group">
        	<label>Descripción: <textarea class="form-control" name="desc" required="required" rows="4" cols="50"></textarea></label>
        </div>
        <div class="form-group">
        	<label>Precio: <input class="form-control" type="number" step="0.01" name="price" required="required"/></label> 
        	<p class="text-danger">${errorsB}</p>
    	</div>
    	<input type="submit" value="Crear" class="btn btn-default"/>
	</form>
	</div>
</body>
</html>