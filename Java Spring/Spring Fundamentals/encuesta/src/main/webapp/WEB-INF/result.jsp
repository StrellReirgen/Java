<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Resultados</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div id="caja" class="container bg-dark">
		<label>Nombre:  <p><c:out value="${name}"/></p></label>
		<label>Lugar:   <p><c:out value="${place}"/></p></label>
		<label>Lenguaje:  <p><c:out value="${lenguaje}"/></p></label>
		<label>Comentario:  <p><c:out value="${message}"/></p></label>
		 <a href="/" class="btn btn-outline-danger">Volver</a> 
	</div>
</body>
</html>