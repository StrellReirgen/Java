<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html >
	<head>
		<meta charset="UTF-8">
		<title>Tablero de Damas</title>
		<link 
			rel="stylesheet" 
			href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" 
			integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" 
			crossorigin="anonymous">
	</head>
	<body class="bg-primary">
		<% 
		int width = Integer.parseInt(request.getParameter("width")); 
		int height = Integer.parseInt(request.getParameter("height"));
		boolean repetido = false;
		String blanco = "<div class='col px-0'><img src='resources/img/blanco.png' class='img-fluid mx-0 w-100 h-100'></img></div>";
		String negro = "<div class='col px-0'><img src='resources/img/negro.png' class='img-fluid mx-0 w-100 h-100'></img></div>";
		%>
		
		<div class="container">
			<p class="display-4 text-center">Tablero de Lobos: <%=width%>x / <%=height%>y</p>
			<% 
			for (int i = 0;i<height;i++){
			%>
				<div class="row">
					<%
					for (int e = 0; e < width; e++) {
						if (repetido == false) {
					%>
						<%=blanco%>
				
						<%
						repetido = true;
						} else {
						%>
						<%=negro%>
						<% 
						repetido = false;
						}
						%>
					<% 	
					}
					%>
				</div>
			<% 	
			}
			%>
		</div>
	</body>
</html>