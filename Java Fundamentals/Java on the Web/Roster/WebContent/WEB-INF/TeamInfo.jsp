<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Roster</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="bg-dark">
	<% 
		int id = Integer.parseInt(request.getParameter("id"));
	%>
	<div class="container">
		<div class="text-center mt-4"><img class="border rounded" src="resources/grupo.jpg" width="400"></div>
		<h1 class="text-center pt-4 text-primary display-4"><c:out value="${tname}"/></h1>
		<div class="text-center mt-4">
			<a class="btn btn-outline-warning p-1 rounded-pill" role="button" href="/Roster/home">Regresar</a>
			<a class="btn btn-outline-primary p-1 rounded-pill" role="button" href="/Roster/players?id=<%=id%>">Nuevo Miembro</a>
		</div>
		<p class="text-center mt-3 text-light h3">Lista de Jugadores</p>
		<table class="table table-bordered mt-5">
			<% String output = (String) session.getAttribute("salida");%>
			<%=output%>
		</table>
	</div>
</body>
</html>