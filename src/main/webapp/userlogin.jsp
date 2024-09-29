<%@page import="product.UserBean"%>
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
UserBean ub=(UserBean)session.getAttribute("ubean");
out.print("Welcome to user..."+ub.getUname());
%>
<a href='viewuserpdct'>View All Product</a>
<a href='userlogoutserv'>Log Out</a>
</body>
</html>