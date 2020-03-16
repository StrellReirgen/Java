<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Botón Clicker</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container bg-dark p-5">
		<h1 class="display-3 text-center text-light">Botón Clicker</h1>
		<p class="h3 text-center text-light">¡Has Click en el botón!</p>
		<div class="text-center"><a href="/Clicker/home"><button class="btn btn-outline-success btn-lg">¡Click!</button></a></div>
		<h1 class="display-4 text-center text-light">¡Pulsado: <c:out value="${count}"/> veces!</h1>
	</div>
</body>
</html>