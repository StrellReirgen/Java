<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Nueva Canción</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="/css/style.css"/>
</head>
<body>
	<div class="container text-center mt-4 p-5 caja">
		<h2 class="display-4 text-light">Nueva Canción</h2>
		<div class="formulario">
		<form:form action="/dashboard" method="post" modelAttribute="dato">
    	<p class="form-group row">
        	<form:label class="text-light col col-form-label" path="title">Título</form:label>
        	<form:errors path="title"/>
        	<form:input path="title" class="col form-control"/>
    	</p>
    	<p class="form-group row">
        	<form:label class="text-light col col-form-label" path="artist">Artista</form:label>
        	<form:errors path="artist"/>
        	<form:input path="artist" class="col form-control"/>
    	</p>
    	<p class="form-group row">
        	<form:label class="text-light col col-form-label" path="url">Vínculo</form:label>
        	<form:errors path="url"/>
        	<form:input path="url" class="col form-control"/>
    	</p> 
    	<p class="form-group row">
        	<form:label class="text-light col col-form-label" path="rating">Puntuación</form:label>
        	<form:errors path="rating"/>
        	<form:input type="number" path="rating" class="col form-control"/>
    	</p>   
    	<input type="submit" class="btn btn-success" value="Crear"/>
    	<a href="/dashboard" class="btn btn-warning">Volver</a>
		</form:form>
		</div> 
	</div>
</body>
</html>