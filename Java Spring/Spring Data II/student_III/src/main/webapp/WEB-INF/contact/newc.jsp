<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nuevo Ninja</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
</head>
<body>
	<div class="container">
	<h2>Nuevo Ninja</h2>
	<form action="/contact/new" method="post">
    	<label>Elige Estudiante: <select name="user">
					<c:forEach var="alumno" items="${lista}">
							<c:if test="${alumno.contact == null}">
        						<option value="${alumno.id}">${alumno.firstName} ${alumno.lastName}</option>
        					</c:if>
   					</c:forEach></select></label>
   		<div class="form-group">
    	<label>Dirección: <input required="required" type="text" name="address" class="form-control"/></label>
    	</div>
    	<div class="form-group">
        <label>Ciudad: <input type="text" name="city" required="required" class="form-control"/></label>
        </div>
        <div class="form-group">
        <label>Estado: <input type="text" name="state" required="required" class="form-control"/></label>
        </div>
    	<input type="submit" value="Crear"/>
    	<a href="/students">Volver</a>
	</form>
	</div>
</body>
</html>