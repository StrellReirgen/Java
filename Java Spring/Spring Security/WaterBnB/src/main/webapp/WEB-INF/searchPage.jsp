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
    <h1>Encuentra tu sitio</h1>
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
    <c:choose>
    	<c:when test="${pools.size() > 0}">
    		<table>
    			<thead>
						<tr>
							<th>Dirección</th>
							<th>Tamaño Piscina</th>
							<th>Costo por Noche</th>
							<th>Detalles</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${pools}" var="site">
							<tr>
								<td>${site.address}</td>
								<td>${site.size}</td>
								<td>${site.cost}</td>
								<td><a href="/pools/${site.id}">Ver Mas</a></td>
							</tr>				
						</c:forEach>
					</tbody>	
    		</table>
    	</c:when>
    	<c:otherwise>
    		<h4>no hay ninguna piscina con esa direccion.</h4>
    	</c:otherwise>
    </c:choose>
</body>
</html>