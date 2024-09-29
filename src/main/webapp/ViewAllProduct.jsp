<%@page import="product.ProductBean.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import ="product.*,java.util.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
ArrayList<ProductBean> al= (ArrayList<ProductBean>) session.getAttribute("albean");
Iterator<ProductBean> il =al.iterator();

%>
<table border="1">
<tr>
<th>Code</th>
<th>Name</th>
<th>Price</th>
<th>Qty</th>
<th>Edit</th>
<th>Delete</th>
</tr>
<%
while(il.hasNext()){
ProductBean pb= (ProductBean)il.next();

%>
<tr>
<td><%= pb.getCode()%></td>
<td><%= pb.getName()%></td>
<td><%= pb.getPrice()%></td>
<td><%= pb.getQty()%></td>
<td><a href='editserv?code=<%= pb.getCode() %>'>Edit</a></td>
<td><a href='deleteserv?code=<%= pb.getCode() %>'>Delete</a></td>
</tr>
<%
}
%>
</table>
<a href='product.html'>Add Product</a>
<a href='logoutserv'>Logout</a>
</body>
</html>