<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
</head>
<body>
	<c:if test="${logoutMessage != null}">
        <c:out value="${logoutMessage}"></c:out>
    </c:if>
    <div>
	<h1>Register!</h1>
    
    <p><form:errors path="user.*"/></p>
    
    <form:form method="POST" action="/registration" modelAttribute="user">
        <p>
            <form:label path="firstname">Nombre:</form:label>
            <form:input path="firstname"/>
        </p>
        <p>
            <form:label path="lastname">Apellido:</form:label>
            <form:input path="lastname"/>
        </p>
        <p>
            <form:label path="username">E-mail:</form:label>
            <form:input path="username"/>
        </p>
        <p>
            <form:label path="password">Contraseña:</form:label>
            <form:password path="password"/>
        </p>
        <p>
            <form:label path="passwordConfirmation">Confirma Contraseña:</form:label>
            <form:password path="passwordConfirmation"/>
        </p>
        <p>
			<select name="role">
        		<option value="${roles[0].id}">Invitado</option>
        		<option value="${roles[1].id}">Anfitrión</option>
			</select>
		</p>
        <input type="submit" value="Register!"/>
    </form:form>
	</div>
    <div>
    <h1>Login</h1>
    <c:if test="${errorMessage != null}">
        <c:out value="${errorMessage}"></c:out>
    </c:if>
		<form method="POST" action="/login">
			<p>
    			<label for="username">E-mail:</label>
    			<input type="text" id="username" name="username"/>
			</p>
			<p>
    			<label for="password">Contraseña:</label>
    			<input type="password" id="password" name="password"/>
			</p>
				<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
				<input type="submit" value="Ingresar!"/>
		</form>
	</div>
	<a href="/">Volver</a>
</body>
</html>