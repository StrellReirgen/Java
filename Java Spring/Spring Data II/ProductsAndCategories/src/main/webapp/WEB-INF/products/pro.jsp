<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${products.name}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<a href="/">Home</a> | <a href="/products/new">Agregar un Producto</a> | <a href="/categories/new">Agregar una Categoria</a>
		<h1>${product.name}</h1>
		<h3>Categorias</h3>
		<ul>
			<c:forEach items="${products.categories}" var="category">
				<li>${category.name}</li>
			</c:forEach>
		</ul>
		<c:if test="${!empty category}">
		<h3>Agregar una Categoria</h3>
		<form action="/products/${products.id}" method="POST">
			<div class="form-group">
				<label for="category">Category:</label>
				<select name="category">
					<c:forEach items="${category}" var="categoria">
        					<option value="${categoria.id}">${categoria.name}</option>
   					</c:forEach>
				</select>
			</div>
			<input type="submit" value="Agregar Categoria" class="btn btn-default">
		</form>
		</c:if>
	</div>
</body>
</html>