<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nueva Categoria</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Nueva Categoria</h1>
		<a href="/">Home</a> | <a href="/products/new">Agregar un Producto</a>
		<form action="/categories/new" method="POST">
			<div class="form-group">
				<label>Nombre: <input type="text" name="name" required="required" class="form-control"/>
				</label>
			</div>
				<input type="submit" value="Crear Categoria" class="btn btn-default">		
		</form>
		<p class="text-danger">${errors}</p>
	</div>
</body>
</html>