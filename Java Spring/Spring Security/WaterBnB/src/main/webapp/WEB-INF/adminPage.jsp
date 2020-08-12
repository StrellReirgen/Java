<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Admin Page</title>
</head>
<body>
    <h1>Sitios Actuales</h1>
    <a href="/">Home</a>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Cerrar Sesion" />
    </form>
    <c:choose>
    	<c:when test="${user.myPools.size() > 0}">
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
						<c:forEach items="${user.myPools}" var="site">
							<tr>
								<td>${site.address}</td>
								<td>${site.size}</td>
								<td>${site.cost}</td>
								<td><a href="/host/pool/${site.id}">Editar</a></td>
							</tr>				
						</c:forEach>
					</tbody>	
    		</table>
    	</c:when>
    	<c:otherwise>
    		<h4>No tienes ningun sitio en este momento.</h4>
    	</c:otherwise>
    </c:choose>
    <div>
    	<h3>Nuevo Sitio</h3>
    	<form action="/host/newpool" method="post">
    		<p>
    			<label>Dirección: <input required="required" type="text" name="address"/></label>
    		</p>
    		<p>
    		<label>Descripción: <textarea required="required" name="desc" rows="10" cols="30"></textarea></label>
    		</p>
    		<p>
    		<label>Valor la Noche: <input required="required" type="number" step="0.01" name="cost" placeholder="0.00"/></label>
    		</p>
    		<p>
    		<label>Tamaño de piscina: 
    			<select name="size">
    				<option value="Pequeña">Pequeña</option>
    				<option value="Mediana">Mediana</option>
    				<option value="Grande">Grande</option>
    			</select>
    		</label>
    		</p>
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<input type="submit" value="Crear"/>
    	</form>
    </div>
</body>
</html>