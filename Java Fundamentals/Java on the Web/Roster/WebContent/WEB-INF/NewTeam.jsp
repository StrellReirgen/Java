<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Roster</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="bg-dark">
	<div class="container">
		<div class="justify-content-center row mt-4">
			<img src='resources/terran.png' width="200">
			<img src='resources/protoss.png' width="200">
			<img src='resources/zerg.png' width="200">
		</div>
	<form action='/Roster/home' method='POST'>
		<h1 class="text-center pt-4 text-primary display-4">Elige un nombre para el nuevo Equipo</h1>
		<div class="text-center mt-4"><input type='text' name='team'></div>
		<div class="text-center mt-4">
			<a class="btn btn-outline-danger p-2 rounded-pill" role="button" href="/Roster/home">Cancelar</a>
			<button class="btn btn-outline-success p-2 rounded-pill">Agregar</button>
		</div>
	</form>
	</div>
</body>
</html>