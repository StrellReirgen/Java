<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Palabra Aleatoria</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class ="bg-dark">
	<div class="container p-5">
		<h1 class="display-3 text-center text-success">Palabras Aleatorias</h1>
		<p class="h3 text-center text-success">Has generado una palabra <c:out value="${count}"/> veces.</p>
		<hr>
		<h1 class=" text-center text-light border border-success rounded"><c:out value="${palabra}"/></h1>
		<hr>
		<div class="text-center"><a href="/Random/home"><button class="btn btn-outline-danger btn-lg">Generar Palabra</button></a></div>
		<h1 class="h2 text-center text-success">La ultima palabra que has generado fue hace:</h1>
		<h1 class="display-4 text-center text-success"><c:out value="${fecha}"/></h1>
	</div>
</body>
</html>