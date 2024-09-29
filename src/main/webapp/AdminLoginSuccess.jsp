<%@page import="product.AdminBean"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="product.AdminBean.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
AdminBean ab = (AdminBean) session.getAttribute("ubean");
String fname=ab.getFname();
out.print("Welcome Admin"+fname);
%>
<a href="product.html">Add Product</a>
<a href="viewall">ViewAll Product</a>
<a href="logoutserv">Log Out </a>
</body>
</html>