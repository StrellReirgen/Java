<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Libros</title>
</head>
<body>
<h1>Todos los Libros</h1>
<table>
    <thead>
        <tr>
            <th>Título</th>
            <th>Descripción</th>
            <th>Idioma</th>
            <th>Número de Página</th>
        </tr>
    </thead>
    <tbody>
        <c:forEach items="${books}" var="libro">
        <tr>
            <td><c:out value="${libro.title}"/></td>
            <td><c:out value="${libro.description}"/></td>
            <td><c:out value="${libro.language}"/></td>
            <td><c:out value="${libro.numberOfPages}"/></td>
        </tr>
        </c:forEach>
    </tbody>
</table>
<a href="/books/new">Nuevo Libro</a>
</body>
</html>