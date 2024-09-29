<%@page import="product.ProductBean"%>
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
ProductBean pb=(ProductBean)request.getAttribute("pcode");
request.setAttribute("pb", pb);
%>
<form action="usertransserv" method="get">
Product code<input type="text" name="code" value=<%=pb.getCode() %> readonly><br>
Product Name<input type="text" name="name" value=<%=pb.getName() %> readonly><br>
 Price<input type="text" name="price" value=<%=pb.getPrice() %>readonly><br>
 Available quantity <%=pb.getQty() %><input type="text" name="qty"><br>
Address:<textarea rows="10" cols="20" name="address"></textarea>
<input type="submit" value="Buy">

</form>
</body>
</html>