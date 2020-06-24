<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Perdido en el Himalaya</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="bg-dark">
	<div class="text-center mt-4">
		<h1 class="display-4 text-danger"><c:out value="${error}"/></h1>
		<p class="text-light">Llevas varios días caminando sin rumbo por las montañas del Himalaya, hasta que encuentras a un extraño monje frente a una cueva.</p>
		<p class="text-light">-Bienvenido joven saltamontes, ¿Cual es el significado del Poder?</p>
		<form method="POST" action="/pass">
    		<input type="text" name="respuesta">
    		<button>Responder</button>
		</form>
	</div>
</body>
</html>