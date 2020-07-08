<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Lenguajes de Programación</title>
</head>
<body>
	<h1>Lenguajes de Programación</h1>
	<div>
		<h1>Nuevo Lenguaje</h1>
		<form:form action="/languages" method="post" modelAttribute="dato">
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
	</div>
	<div>
		<table>
    		<thead>
        		<tr>
            		<th>Nombre</th>
            		<th>Creador</th>
            		<th>Versión</th>
        		</tr>
    		</thead>
    		<tbody>
        		<c:forEach items="${lenguajes}" var="lenguaje">
        		<tr>
            		<td><a href="/languages/${lenguaje.id}"><c:out value="${lenguaje.name}"/></a></td>
            		<td><c:out value="${lenguaje.creator}"/></td>
            		<td><c:out value="${lenguaje.version}"/></td>
        		</tr>
        		</c:forEach>
    		</tbody>
		</table>
	</div>
</body>
</html>