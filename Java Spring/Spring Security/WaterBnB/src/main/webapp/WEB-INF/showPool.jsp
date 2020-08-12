<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>piscina</title>
</head>
<body>
	<a href="/">Home</a>
    <c:choose>
    	<c:when test="${user == null}">
    		<a href="/login">Registrate/Inicia Sesion</a>
    	</c:when>
    	<c:otherwise>
    		<c:forEach items="${user.roles}" var="rol">
    			<c:if test="${rol.id == 2}">
    				<a href="/host/dashboard">Dashboard</a>
    			</c:if>
    		</c:forEach>
    		<form id="logoutForm" method="POST" action="/logout">
        		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        		<input type="submit" value="Cerrar Sesion" />
    		</form>
    	</c:otherwise>
    </c:choose>
    <h4>Email: ${pool.host.username}</h4>
    <h4>Anfitrion: ${pool.host.firstname} ${pool.host.lastname}</h4>
    <h5>${pool.address}</h5>
    <h5>Costo por noche: ${pool.cost}</h5>
    <h5>Tamaño piscina: ${pool.size}</h5>
    <p>${pool.description}</p>
	<c:choose>
    	<c:when test="${pool.reviews.size() > 0}">
    		<h4>Comentarios: </h4>
    		<a href="/${pool.id}/review">Dejar comentario</a>
    		<div>
				<c:forEach items="${pool.reviews}" var="rev">
					<div>
						<h5>${rev.user.firstname} ${rev.user.lastname}</h5>
						<h5>Nota: ${rev.rating}/5</h5>
						<p>${rev.message}</p>
					</div>				
				</c:forEach>
			</div>
    	</c:when>
    	<c:otherwise>
    		<h4>Este sitio no tiene ningun Comentario.</h4>
    		<a href="/${pool.id}/review">Dejar comentario</a>
    	</c:otherwise>
    </c:choose>
</body>
</html>