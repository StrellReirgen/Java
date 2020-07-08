<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page isErrorPage="true"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editando <c:out value="${lenguaje.name}"/></title>
</head>
<body>
<h1>Editando Lenguaje</h1>
	<form:form action="/languages/${lenguaje.id}" method="post" modelAttribute="lenguaje">
    	<input type="hidden" name="_method" value="put">
    	<p>
        	<form:label path="name">Nombre</form:label>
        	<form:errors path="name"/>
        	<form:input path="name"/>
    	</p>
    	<p>
        	<form:label path="creator">Creador</form:label>
        	<form:errors path="creator"/>
        	<form:input path="creator"/>
    	</p>
    	<p>
        	<form:label path="version">Versión</form:label>
        	<form:errors path="version"/>
        	<form:input path="version"/>
    	</p>  
    	<input type="submit" value="Submit"/>
	</form:form>
</body>
</html>