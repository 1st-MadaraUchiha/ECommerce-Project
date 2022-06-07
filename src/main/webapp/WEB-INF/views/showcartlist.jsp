<%@include file="/WEB-INF/views/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored = "false" %>
<html>
<head>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
	
<meta charset="ISO-8859-1">
<title>Add Cart here</title>
</head>
<body>
<table class="table">
			<thead>
				<tr>
					<th scope="col"></th>
					<th scope="col">Product Id</th>
					<th scope="col">Product Name</th>
					<th scope="col">Quantity</th>
					<th scope="col">Price</th>
					<th scope="col">SubTotal</th>
					<th scope="col">Operation</th>
					<th></th>
				</tr>
			</thead>
			</table>


			<table>
          <c:forEach items="${cart}" var="ct">
<form action="<c:url value="/AddCart/${ct.getCartItemId()}"/>" method="post">

				<tr>
					<th scope="row"></th>
					<th scope="col"><input type="hidden" name="productId" value="${ct.getProductId()}" />${ct.getProductId()}</th>
					<th scope="col"><input type="hidden" name="productName" value="${ct.getProductName()}" />${ct.getProductName()}</th>
					<th scope="col"><input type="number" name="quantity" id="quantity" />Quantity</th>
					<th scope="col"><input type="hidden" name="price" value="${ct.getPrice()}" />${ct.getPrice()}</th>
					<th scope="col"><input type="hidden"  value="${ct.getQuantity()*ct.getPrice()}" />${ct.getQuantity()*ct.getPrice()}</th>
					<th scope="col"><a href="<c:url value="/editCart/${ct.getCartItemId()}/quantity"/>" class="btn btn-danger">Update</a></th>
					<th scope="col"><a href="<c:url value="/deleteCart/${ct.getCartItemId()}"/>" class="btn btn-danger">Delete</a></th>
				</tr>
</form>
			</c:forEach>
			<tr>
			<td>Total Purchase Amount</td>
			<td>${grandTotal}</td>
			</tr>
			<tr>
			<td><a href="<c:url value="/Home"/>">Continue Shopping</a></td>
			<td><a href="#">CheckOut</a></td>
			</tr>	
</table>
			
		

</body>
</html>