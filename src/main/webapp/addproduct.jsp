<%@page import="product.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab=(AdminBean)session.getAttribute("ubean");

out.print("page Belongs to Admin" + ab.getFname()+"<br>");
out.print("Product added successfully..<br>");
%>
<a href="addproduct.html">Add Product</a><br>
<a href="viewall">view All Product</a><br>
<a href="logout">log out</a><br>

</body>
</html>