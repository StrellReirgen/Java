<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Tienda de Mascotas</title>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container bg-success p-5">
		<div class="row justify-content-center">
			<div class="col-5">
				<form action="/Mascotas/dog">
					<div class="form-group">
						<h1 class="display-4 text-center text-light">Pide tu Perro:</h1>
						<label for="inputName" class="text-light">Nombre</label> <input type="text"
							class="form-control" id="inputName" name="name"
							placeholder="Ingresa su nombre">
					</div>
					<div class="form-group">
						<label for="inputBreed" class="text-light">Raza</label> <input type="text"
							class="form-control" id="inputBreed" name="breed"
							placeholder="Ingresa su raza">
					</div>
					<div class="form-group">
						<label for="inputWeight" class="text-light">Peso</label> <input type="number" name="weight" class="form-control"
							id="inputWeight">
					</div>
					<button type="submit" class="btn btn-primary">Ingresar
						Mascota</button>
				</form>
			</div>
			<div class="col-5">
				<form action="/Mascotas/cat">
					<div class="form-group">
						<h1 class="display-4 text-center text-light">Pide tu Gato:</h1>
						<label for="inputName" class="text-light">Nombre</label> <input type="text"
							class="form-control" id="inputName" name="name"
							placeholder="Ingresa su nombre">
					</div>
					<div class="form-group">
						<label for="inputBreed" class="text-light">Raza</label> <input type="text"
							name="breed" class="form-control" id="inputBreed"
							placeholder="Ingresa su raza">
					</div>
					<div class="form-group">
						<label for="inputWeight" class="text-light">Peso</label> <input type="number" class="form-control"
							id="inputWeight" name="weight">
					</div>
					<button type="submit" class="btn btn-primary">Ingresar
						Mascota</button>
				</form>
			</div>
		</div>
	</div>
</body>
</html>