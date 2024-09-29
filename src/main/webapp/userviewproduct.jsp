<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"
    import="product.*,java.util.*"%>
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
<th>Buy</th>
<th>Add to Cart</th>
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
<td><a href='userbuyserv?code=<%= pb.getCode() %>'>Buy</a></td>
<td><a href='usercartserv?code=<%= pb.getCode() %>'>Add to Cart</a></td>
</tr>
<%
}
%>
</table>

<a href='logoutserv'>Logout</a>

</body>

</html>