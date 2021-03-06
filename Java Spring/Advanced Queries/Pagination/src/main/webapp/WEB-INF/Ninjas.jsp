<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>    
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Ninjas</title>
</head>
<body>
	<div id="ninjas">
    <h1>Ninjas</h1>

    <c:forEach begin="1" end="${totalPages}" var="index">
        <a href="/pages/${index}">${index}</a>
    </c:forEach>
    <table class="table">
        <thead>
        	<tr>
        		<th>Dojo</th>
            	<th>First Name</th>
            	<th>Last Name</th>
         	 </tr>
        </thead>
        <tbody>
            <c:forEach var="ninja" items="${ninjas.content}">                 
            <tr>
            	<td>${ninja.dojo.name}</td>
              	<td>${ninja.firstName}</td>
              	<td>${ninja.lastName}</td>
            </tr>
            </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>