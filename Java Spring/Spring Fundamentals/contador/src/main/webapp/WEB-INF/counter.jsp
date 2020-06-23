<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Contador de Visitas</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	
</head>
<body class="bg-dark">
	<div class="container text-center mt-4">
		<h1 class="text-danger">Las Veces que has visitado a Elmo: <c:out value="${count}"/></h1>
		<a href="/" class="mt-2 btn btn-warning btn-sm">¿Vuelves a Elmo?</a>
	</div>
</body>
</html>