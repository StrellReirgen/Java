<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nuevo Ninja</title>
</head>
<body>
	<h2>Nuevo Ninja</h2>
	<form action="/ninja/new" method="post">
    	<label>Elige Dojo: <select name="dojo">
					<c:forEach var="dojo" items="${lugar}">
        						<option value="${dojo.id}">${dojo.name}</option>
   					</c:forEach></select></label>
    	<label>Nombre: <input required="required" type="text" name="name"/></label>
        <label>Apellido: <input type="text" name="lastname" required="required"/></label>
        <label>Edad: <input type="number" name="age" required="required"/></label> 
    	<input type="submit" value="Crear"/>
    	<a href="/">Volver</a>
	</form>
</body>
</html>