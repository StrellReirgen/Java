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
		<div class="text-center"><img src='resources/logo.png' width="400"></div>
		<h1 class="text-center pt-4 text-primary display-4">Participantes a la Liga Mundial de Starcraft 2</h1>
		<div class="text-center"><a class="mt-3 btn btn-outline-primary p-2 rounded-pill" role="button" href="/Roster/teams">Agregar Equipo</a></div>
		<p class="text-center mt-3 text-light h3">Lista de Equipos</p>
		<table class="table table-bordered mt-5">
			<% String output = (String) session.getAttribute("salida");%>
			<%=output%>
		</table>
	</div>
</body>
</html>