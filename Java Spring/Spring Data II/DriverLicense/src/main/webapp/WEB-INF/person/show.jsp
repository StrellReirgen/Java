<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>${usuario.firstName} ${usuario.lastName}</title>
</head>
<body>
	<div>
		<h1>${usuario.firstName} ${usuario.lastName}</h1>
		<h3>R.U.N.: ${usuario.rut}</h3>
		<c:if test="${usuario.license != null}">
		<div>
			<p>Numero de licencia: ${usuario.license.number}</p>
			<p>Estado: ${usuario.license.state}</p>
			<p>Fecha de Expiracion: <fmt:formatDate pattern ="dd-MM-yyyy" value = "${usuario.license.expirationDate}" /></p>
		</div>
		</c:if>
	</div>
</body>
</html>