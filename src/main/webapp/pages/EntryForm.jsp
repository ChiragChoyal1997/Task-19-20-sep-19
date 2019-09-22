<%@ page language="java" isELIgnored="false" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Entry Form</title>
</head>
<body>
<%
Boolean success = (Boolean) request.getAttribute("result");
if(success == null ){
%>
<h3 align="center">Employee Entry Form</h3>
<%}
else if(success != null && success == true){
%>
<h3 align="center">Employee Record Has Been Inserted !</h3>
<%} 
else{
%>
<h3 align="center">Employee ID already exists !</h3>
<%} %>
<hr>
<div style="margin-left:41%;">
<fr:form action="entryemployee" modelAttribute="Emp">
<table>
<tr><td><fr:label path="">ID</fr:label></td><td><fr:input path="eno"/></td><td><fr:errors path="eno"/></td></tr>
<tr><td><fr:label path="">Name</fr:label></td><td><fr:input path="ename"/></td><td><fr:errors path="ename"/></td></tr>
<tr><td><fr:label path="">Email</fr:label></td><td><fr:input path="email"/></td><td><fr:errors path="email"/></td></tr>
<tr><td><fr:label path="">Salary</fr:label></td><td><fr:input path="sal"/></td><td><fr:errors path="sal"/></td></tr>
<tr><td></td><td><input style="width:50%" type="submit"><input style="width:50%" type="reset"></td></tr>
</table>
</fr:form>
</div>
<%if(success != null ) {%>
<a href="entryform">Add-More-Employee</a>
<%} %>
<hr><br>
<a href="index.jsp">Go-Back-To-Dashboard</a>
</body>
</html>