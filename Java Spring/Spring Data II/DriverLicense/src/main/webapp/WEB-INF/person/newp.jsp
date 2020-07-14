<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Nueva Persona</title>
</head>
<body>
	<h2>Nueva Persona</h2>
	<form:form action="/persons/new" method="post" modelAttribute="dato">
    	<p>
        	<form:label path="firstName">Nombre</form:label>
        	<form:errors path="firstName"/>
        	<form:input path="firstName"/>
    	</p>
    	<p>
        	<form:label path="lastName">Apellido</form:label>
        	<form:errors path="lastName"/>
        	<form:input path="lastName"/>
    	</p>
    	<p>
        	<form:label path="rut">R.U.N.</form:label>
        	<form:errors path="rut"/>
        	<form:input path="rut"/>
    	</p> 
    	<input type="submit" value="Crear"/>
    	<a href="/">Volver</a>
		</form:form>
</body>
</html>