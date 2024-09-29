<%@page import="java.util.Iterator"%>
<%@page import="product.ProductBean"%>
<%@page import="java.util.ArrayList"%>
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
  ArrayList<ProductBean> al= (ArrayList<ProductBean>) session.getAttribute("albean");
 String code= (String)request.getParameter("code");
 Iterator<ProductBean> il =al.iterator();
 while(il.hasNext()){
	 ProductBean pb =(ProductBean)il.next();
	 if(code.equals(pb.getCode())){
		 
	
 
%>
<form action="updateserv" method="post">
Price:<input type="text" name="price" value=<%=pb.getPrice() %>><br>
Quantity:<input type="text" name="qty" value=<%=pb.getQty() %>><br>
<input type="hidden" name="code" value=<%=pb.getCode() %>>
<input type="submit" value="update">
</form>
<%
break;
}
 }
%>
</body>
</html>