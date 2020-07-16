<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Productos y Categorias</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
		<h1>Productos y Categorias</h1>
		<a href="/products/new">Agregar un Producto</a> | <a href="/categories/new">Agregar una Categoria</a>
		<h3>Categorias</h3>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>Categorias</th>
					<th>Cantidad de Productos</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${categories}" var="category">
					<tr>
						<td><a href="/categories/${category.id}"><c:out value="${category.name}"/></a></td>
						<td><c:out value="${category.getProducts().size()}"></c:out></td>
						<td><form action="/categories/${category.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Borrar"/>
							</form></td>
					</tr>				
				</c:forEach>
			</tbody>		
		</table>
		<h3>Productos</h3>
		<table class="table table-striped table-hover table-bordered">
			<thead>
				<tr>
					<th>Productos</th>
					<th>Descripción</th>
					<th>Precio</th>
					<th>Cantidad de Categorias</th>
					<th>Acciones</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${products}" var="product">
					<tr>
						<td><a href="/products/${product.id}"><c:out value="${product.name}"/></a></td>
						<td><c:out value="${product.description}"/></td>
						<td><c:out value="${product.price}"/></td>
						<td><c:out value="${product.getCategories().size()}"></c:out></td>
						<td><form action="/products/${product.id}" method="post">
								<input type="hidden" name="_method" value="delete">
								<input type="submit" value="Borrar"/>
							</form></td>
					</tr>				
				</c:forEach>
			</tbody>		
		</table>
	</div>
</body>
</html>