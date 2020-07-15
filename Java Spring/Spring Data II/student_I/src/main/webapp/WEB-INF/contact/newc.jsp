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
	<form action="/contact/new" method="post">
    	<label>Elige Estudiante: <select name="user">
					<c:forEach var="alumno" items="${lista}">
							<c:if test="${alumno.contact == null}">
        						<option value="${alumno.id}">${alumno.firstName} ${alumno.lastName}</option>
        					</c:if>
   					</c:forEach></select></label>
    	<label>Dirección: <input required="required" type="text" name="address"/></label>
        <label>Ciudad: <input type="text" name="city" required="required"/></label>
        <label>Estado: <input type="text" name="state" required="required"/></label> 
    	<input type="submit" value="Crear"/>
    	<a href="/students">Volver</a>
	</form>
</body>
</html>