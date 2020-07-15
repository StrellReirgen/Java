<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojos del Mundo</title>
</head>
<body>
	<h1>Dojos del Mundo</h1>
	<a href="/dojo/new">Nuevo Dojo</a>
	<a href="/ninja/new">Inscribir a un Ninja</a>
	<table>
		<thead>
			<tr>
				<th>Nombre del Dojo</th>
				<th>Ninja Count</th>
				<th>Acciónes</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="dojo" items="${lugar}">
			<tr>
				<td><a href="/dojo/${dojo.id}">${dojo.name}</a></td>
				<td>${dojo.ninjas.size()} Ninjas</td>
				<td>
					<form action="/dojo/${dojo.id}" method="post">
						<input type="hidden" name="_method" value="delete">
						<input type="submit" value="Borrar"/>
					</form>
				</td>			
			</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>