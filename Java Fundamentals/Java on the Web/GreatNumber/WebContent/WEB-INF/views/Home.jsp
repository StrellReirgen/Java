<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Juego Great Number</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="bg-dark">
	<div class="container p-5">
		<h1 class="display-4 text-center text-success">Bienvenido al juego de Great Number</h1>
		<p class="h3 text-center text-success">Estoy Pensando en un numero entre el 1 y el 100</p>
		<h1 class="display-4 text-center text-success">¡intenta adivinarlo!</h1>
		<hr>
		<form action='/GreatNumber/game' method='POST'>
				<div class='text-center'><input type='text' name='number'></div>
				<hr>
				<div class='text-center'><button class='btn btn-outline-danger btn-lg'>Adivinar</button></div> 
		</form>
	</div>
</body>
</html>