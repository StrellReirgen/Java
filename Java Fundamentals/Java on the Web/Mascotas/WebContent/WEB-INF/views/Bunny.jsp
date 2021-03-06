<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Un Conejito</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
	<div class="container bg-success p-3">
		<h1 class="display-3 text-center text-light">Has adoptado a <c:out value="${bunny.getName()}"/>, un conejito <c:out value="${bunny.getBreed()}"/></h1>
		<img src="resources/img/conejo.jpg" class='w-50 img-thumbnail rounded mx-auto d-block'>
		<h1 class="display-4 text-center text-light"><c:out value="${bunny.showAffection()}"/></h1>
	</div>
</body>
</html>