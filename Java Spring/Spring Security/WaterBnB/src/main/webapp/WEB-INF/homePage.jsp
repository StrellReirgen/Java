<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Water BnB</title>
</head>
<body>
    <h1>Encuentra lugares para nadar y dormir en Water BnB</h1>
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
    <form method="POST" action="/search">
    	<input type="text" name="location"/>
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Buscar" />
    </form>
</body>
</html>