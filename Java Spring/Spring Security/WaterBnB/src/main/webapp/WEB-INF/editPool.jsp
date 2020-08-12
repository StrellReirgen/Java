<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
	<title>Editando sitio</title>
</head>
<body>
	<a href="/">Home</a>
    <form id="logoutForm" method="POST" action="/logout">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
        <input type="submit" value="Cerrar Sesion" />
    </form>
    <h4>Email: ${user.username}</h4>
    <h4>Anfitrion: ${user.firstname} ${user.lastname}</h4>
	<form:form action="/host/pool/${pool.id}" method="post" modelAttribute="pool">
    		<p>
        		<form:label path="address">Dirección: </form:label>
        		<form:input path="address"/>
    		</p>
    		<p>
        		<form:label path="description">Descripción: </form:label>
        		<form:textarea path="description"/>
    		</p>
    		<p>
        		<form:label path="cost">Costo por Noche: </form:label>
        		<form:input tipe="number" step="0.01" path="cost"/>
    		</p>
    		<p>
        		<form:label path="size">Tamaño Piscina</form:label>
        		<form:select path="size">
                	<form:option value="Pequeña">Pequeña</form:option>
                	<form:option value="Mediana">Mediana</form:option>
                	<form:option value="Grande">Grande</form:option>
            	</form:select>
    		</p>  
    		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    		<input type="submit" value="Guardar Cambios"/>
    		<a href="/host/dashboard">Volver</a>
	</form:form>
	<c:choose>
    	<c:when test="${pool.reviews.size() > 0}">
    		<h4>Comentarios:</h4>
    		<div>
				<c:forEach items="${pool.reviews}" var="rev">
					<div>
						<h5>${rev.user.firstname} {rev.user.lastname}</h5>
						<h5>Nota: ${rev.rating}/5</h5>
						<p>${rev.message}</p>
					</div>				
				</c:forEach>
			</div>
    	</c:when>
    	<c:otherwise>
    		<h4>Este sitio no tiene ningun Comentario.</h4>
    	</c:otherwise>
    </c:choose>
</body>
</html>