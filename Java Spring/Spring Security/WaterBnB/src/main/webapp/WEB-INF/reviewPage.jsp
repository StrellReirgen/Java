<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>Comentando</title>
</head>
<body>
	<a href="/">Home</a>
    <c:forEach items="${user.roles}" var="rol">
    	<c:if test="${rol.id == 2}">
    		<a href="/host/dashboard">Dashboard</a>
    	</c:if>
    </c:forEach>
    <form id="logoutForm" method="POST" action="/logout">
       	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
       	<input type="submit" value="Cerrar Sesion" />
    </form>	
    <h5>${pool.address}</h5>
	<form action="/${pool.id}/review" method="post">
    		<p>
        		<label>Mensaje: <textarea name="message"></textarea></label>
    		</p>
    		<p>
        		<label>Puntuacion: <input type="number" min="0" max="5" step="0.01" name="rating"/></label>
    		</p>
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<input type="submit" value="Comentar"/>
    		<a href="/pools/${pool.id}">Volver</a>
	</form>
	
</body>
</html>