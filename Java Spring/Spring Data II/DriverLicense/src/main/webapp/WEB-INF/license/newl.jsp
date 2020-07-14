<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Licencia</title>
</head>
<body>
	<h2>Nueva Licencia</h2>
	<form action="/licenses/new" method="post">
        	<label>Fecha de vencimiento: <input type="date" name="date" required="required"/></label>
        	<label>Región: <input type="text" name="state" required="required"/></label>
    	<p>
        	<label>Usuario: <select name="usuario">
					<c:forEach var="persona" items="${users}">
							<c:if test="${persona.license == null}">
        						<option value="${persona.id}"><c:out value="${persona.firstName} ${persona.lastName}"/></option>
        					</c:if>
   					</c:forEach></select></label>
    	</p>
    	<input type="submit" value="Crear"/>
    	<a href="/">Volver</a>
		</form>
</body>
</html>