<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>${category.name}</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<a href="/">Home</a> | <a href="/products/new">Agregar un Producto</a> | <a href="/categories/new">Agregar a Categorias</a>
		<h1>${category.name}</h1>
		<h3>Productos</h3>
		<ul>
			<c:forEach items="${category.products}" var="product">
				<li><c:out value="${product.name}"/></li>
			</c:forEach>
		</ul>
		<c:if test="${!empty products}">
			<h3>Agregar a Productos</h3>
			<form action="/categories/${category.id}" method="POST">
				<div class="form-group">
					<label for="product">Productos:</label>
					<select name="product">
						<c:forEach items="${products}" var="product">
	        					<option value="${product.id}">${product.name}</option>
	   					</c:forEach>
					</select>
				</div>
				<input type="submit" value="Agregar Producto" class="btn btn-default">
			</form>
		</c:if>
	</div>
</body>
</html>