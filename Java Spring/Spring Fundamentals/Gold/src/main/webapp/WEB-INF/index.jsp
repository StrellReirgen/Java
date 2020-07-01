<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Ninja Gold</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container text-center mt-4 bg-dark p-3">
		<h1 class="text-light">Bienvenido a Ninja Gold</h1>
		<div class="row">
			<div class="col"><img class="info icono" src="img/gold.png"><p class="info ml-2 text-light">Oro: <c:out value="${gold}"/></p></div>
			<div class="col">
				<form method="POST" action="/reset">
    				<button class="btn btn-outline-danger" type="submit" name="boton">Reiniciar</button>
				</form>
			</div>
			<div class="col"><img class="info icono" src="img/vida.png"><p class="info ml-2 text-light">Salud: <c:out value="${salud}"/></p></div>
		</div>
		<div class="row mt-3">
			<form class="col" method="POST" action="/farm">
    			<button class="btn btn-outline-light" type="submit" name="boton"> <img class="viaje" src="img/farm.png"></button>
			</form>
			<form class="col" method="POST" action="/cave">
    			<button class="btn btn-outline-light" type="submit" name="boton"><img class="viaje" src="img/cave.png"></button>
			</form>
			<form class="col" method="POST" action="/house">
    			<button class="btn btn-outline-light" type="submit" name="boton"><img class="viaje" src="img/house.png"></button>
			</form>
		</div>
		<div class="row mt-3">
			<form class="col" method="POST" action="/casino">
    			<button class="btn btn-outline-light" type="submit" name="boton"><img class="viaje" src="img/casino.png"></button>
			</form>
			<form class="col" method="POST" action="/food">
    			<button class="btn btn-outline-light" type="submit" name="boton"><img class="viaje" src="img/food.png"></button>
			</form>
			<form class="col" method="POST" action="/game">
    			<button class="btn btn-outline-light" type="submit" name="boton"><img class="viaje" src="img/game.png"></button>
			</form>
		</div>
		<h2 class="text-light">Actividades:</h2>
		<div id="actividad" class="overflow-auto">
          <% ArrayList<String> activities = (ArrayList<String>) session.getAttribute("activities");
             for(String activity : activities) {
			 	if(activity.toLowerCase().contains("perdiste".toLowerCase())) {%>
				<p class="red"><%= activity %></p>
			 <% }else{ %>
				<p class="green"><%= activity %></p>
			 <% }
		     } %>
		</div>
	</div>
	<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
	<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
	<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>