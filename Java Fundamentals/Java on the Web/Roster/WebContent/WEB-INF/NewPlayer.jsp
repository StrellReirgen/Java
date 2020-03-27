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
	<form action='/Roster/teams?id=<%=id%>' method='POST'>
		<div class="text-center mt-2"><img class="border rounded" src="resources/team.jpg" width="400"></div>
		<h1 class="text-center mt-1 text-primary display-4">Agregar un nuevo miembro a <c:out value="${tname}"/></h1>
		<div class="form-group row mt-3 justify-content-center">
			<label class="text-primary col-sm-2 col-form-label">Nombre:</label>
			<div>
				<input type='text' name='name'>
			</div>
		</div>
		<div class="form-group row justify-content-center">
			<label class="text-primary col-sm-2 col-form-label">Raza:</label>
			<div>
				<input type='text' name='race'>
			</div>
		</div>
		<div class="form-group row justify-content-center">
			<label class="text-primary col-sm-2 col-form-label">Edad:</label>
			<div>
				<input type='number' name='age'>
			</div>
		</div>
		<div class="text-center mt-4">
			<a class="btn btn-outline-danger p-2 rounded-pill" role="button" href="/Roster/teams?id=<%=id%>">Cancelar</a>
			<button class="btn btn-outline-success p-2 rounded-pill">Agregar</button>
		</div>
	</form>
	</div>
</body>
</html>