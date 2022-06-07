<%@page import="org.springframework.ui.Model"%>
<%@page import="java.io.PrintWriter"%>
<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="Fashion.Model.Product"%>
<html>
<head>
<%@include file="/WEB-INF/views/header.jsp"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">

</head>
<body>
	<h2>Hello World!</h2>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
<table>
<tbody>		

<%int i =0; %>
<c:forEach items="${pro}" var="p">
<% i=i+1;
if(i%6 == 0){
	%>
	<tr><%} 
	else{
		%><%
	}
%>
<th scope="col">
<div>
<p align="center"><a href="<c:url value=""/>" class="thumbnail"/>
<img alt="thumbnail product" src=""></a> </p>
<p align="center">${p.productName}</p>
<p align="center">${p.price}</p>
<p align="center">${p.stock}</p>
<p align="center"><a href="ViewProduct/${p.productId}">View Product</a></p>
</div>
</th>

<%if(i%6 == 0){
	%>
	<tr><%} 
	else{
		%> <%
	}
%>
</c:forEach>



</tbody>

</table>
</body>
</html>
