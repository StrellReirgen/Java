<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Encuesta del Dojo</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
	<link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
	<div id="caja" class="container bg-dark">
	<form method="POST" action="/info">
    		<label>Tu Nombre: <input type="text" name="name"></label>
    		<label>Localización: 
				 <select name="place">
    				<option value="Temuco">Temuco</option>
    				<option value="Lautaro">Lautaro</option>
    				<option value="Padre las Casas">Padre las Casas</option>
    				<option value="Victoria">Victoria</option>
  				</select>
    		</label>
    		<label>Lenguaje: 
    			<select class="lang" name="lenguaje">
    				<option value="Python">Python</option>
    				<option value="C#">C#</option>
    				<option value="Java">Java</option>
    				<option value="Ruby">Ruby</option>
  				</select>
    		</label>
    		<label>Comentario: </label>
    		<textarea name="message" rows="10" cols="45"></textarea>
    		
    		<button class="btn btn-outline-danger">Enviar</button>
	</form>
	</div>
</body>
</html>