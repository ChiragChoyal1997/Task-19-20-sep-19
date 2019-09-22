<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3>Error-Page</h3>
	<hr>
		<h3>All Errors</h3>
	<hr>
		<fr:errors path="Emp.eno"/><br>
		<fr:errors path="Emp.ename"/><br>
		<fr:errors path="Emp.email"/><br>
		<fr:errors path="Emp.sal"/><br>
	<hr>
</body>
</html>