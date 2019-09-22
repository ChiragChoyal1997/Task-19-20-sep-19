<%@page isELIgnored="false" import="com.wp.models.Emp"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="fr" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>    
<% Emp e = (Emp)request.getAttribute("Emp"); %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Update Employee Data</title>
</head>
<body>
<div>
<%
Boolean success = (Boolean) request.getAttribute("result");
if(success == null) {%>
<h3 align="center">Update Employee Data</h3>
<%}
else if(success != null && success == true){ %>
<h3 align="center">Employee Data Updated Successfully !</h3>
<%}%>
<hr>

<!-- Spring form TagLibrary tags -->

<fr:form action="updateemp" method="get" modelAttribute="Emp"><br>
<table style="margin-left: 40%">
<fr:hidden path="eno"/>
<tr><td><fr:label path="">Name</fr:label></td><td><fr:input path="ename"/></td><td><fr:errors path="ename"/></td></tr>
<tr><td><fr:label path="">Email</fr:label></td><td><fr:input path="email"/></td><td><fr:errors path="email"/></td></tr>
<tr><td><fr:label path="">Salary</fr:label></td><td><fr:input path="sal"/><br></td><td><fr:errors path="sal"/></td></tr>
<tr><td></td><td><input style="width: 100%" type="submit"></td></tr>
</table>										
</fr:form>
<hr>
<a href="index.jsp">Go-To-DashBoard</a>
</div>
</body>
</html>