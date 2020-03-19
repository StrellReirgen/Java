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
		<p class="h3 text-center text-success">Estoy Pensando en un numero entre el <c:out value="${minimo}"/> y el <c:out value="${maximo}"/></p>
		<h1 class="display-4 text-center text-success">¡intenta adivinarlo!</h1>
		<hr>
		<% String output = (String) session.getAttribute("salida");%>
		<%=output%>
	</div>
</body>
</html>