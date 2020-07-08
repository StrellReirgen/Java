<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><c:out value="${lenguaje.name}"/></title>
</head>
<body>
	<h1><c:out value="${lenguaje.name}"/></h1>
	<p>Creador: <c:out value="${lenguaje.creator}"/></p>
	<p>Versión: <c:out value="${lenguaje.version}"/></p>
	<a href="/languages/${lenguaje.id}/edit">Editar Lenguaje</a>
	<a href="/languages">Dashboard</a>
	<form action="/languages/${lenguaje.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete">
	</form>
</body>
</html>