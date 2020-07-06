<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Date</title>
    <link rel="stylesheet" type="text/css" href="css/style.css">
    <script type="text/javascript" src="js/date.js"></script>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body class="bg-dark">
	<div class="container">
		<div class="mt-5 text-center">
		<c:set var = "now" value = "${chrono}" />
		<p class="azul display-4"><fmt:formatDate pattern = "E" value = "${now}"/>, <fmt:formatDate pattern = "dd" value = "${now}"/> de <fmt:formatDate pattern = "MMMM" value = "${now}"/>, <fmt:formatDate pattern = "yyyy" value = "${now}"/></p>
		</div>
	</div>
</body>
</html>