<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Editando ${event.name}</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

</head>
<body class="bg-dark">
	<div class="container d-flex justify-content-between">
		<h4 class="text-warning">Editar Evento</h4>
		<a href="/dashboard" class="btn btn-primary">Volver</a>
	</div>
	<div class="container row d-flex justify-content-center">
			<div class="mt-4 col-4">
				<form action="/event/new" method="post">
							
					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-12 form-control" placeholder="${event.name}" required="required" type="text" name="name"/>
					</div>	
					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-12 form-control" required="required" type="date" name="date"/>	
					</div>
					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-12 form-control" placeholder="${event.city}" required="required" type="text" name="city"/>
					</div>	
					<div class="form-group d-flex justify-content-center">
						<select class="mt-1 text-center col-12 form-control" required="required" name="region">
							<option value="${event.region}" selected>${event.region}</option>
        					<option value="Arica y Parinacota">Arica y Parinacota</option>
        					<option value="Tarapacá">Tarapacá</option>
        					<option value="Antofagasta">Antofagasta</option>
        					<option value="Atacama">Atacama</option>
        					<option value="Coquimbo">Coquimbo</option>
        					<option value="Valparaíso">Valparaíso</option>
        					<option value="Metropolitana">Metropolitana</option>
        					<option value="Bernardo O'Higgins">Bernardo O'Higgins</option>
        					<option value="Maule">Maule</option>
        					<option value="Ñuble">Ñuble</option>
        					<option value="Biobío">Biobío</option>
        					<option value="Araucanía">Araucanía</option>
        					<option value="Los Ríos">Los Ríos</option>
        					<option value="Los Lagos">Los Lagos</option>
        					<option value="Aysén">Aysén</option>
        					<option value="Magallanes">Magallanes</option>
						</select>	
					</div>	
					<div class="form-group d-flex justify-content-center">
						<input class="mt-1 text-center col-8 form-control btn btn-warning"  type="submit" value="Ingresar"/>
					</div>
				</form>
			</div>
			<div class="mt-4 col-6">
				<p class="text-center text-danger">${errorA}</p>
				<p class="text-center text-danger">${errorB}</p>
				<p class="text-center text-danger">${errorC}</p>
			</div>
		</div>
	
</body>
</html>