<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
		<h1 class="text-light">Has muerto amigo, no debería sobreexigirse</h1>
		<img src="img/tumba.png" width="200px">
		<form method="POST" action="/reset">
    				<button class="btn btn-outline-danger" type="submit" name="boton">Reiniciar</button>
		</form>
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