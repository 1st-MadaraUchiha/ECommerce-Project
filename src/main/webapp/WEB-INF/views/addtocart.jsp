<html>
<head>
<%@include file="/WEB-INF/views/header.jsp"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor"
	crossorigin="anonymous">
	
<meta charset="ISO-8859-1">
<title>Add Cart here</title>
</head>
<body>
<form  align="centre" action="<c:url value="/AddToCart"/>" method="post">
<table>

<tr>
<td></td>
</tr>
<tr><td></td>
<td>Product Name: </td>
<td>${viewProduct.getProductName()}</td>
</tr>

<tr><td></td>
<td>Product Id: </td>
<td>${viewProduct.getProductId()}</td>
</tr>

<tr><td></td>
<td>Quantity</td>
<td><input type="number" name="quantity" required></td>
</tr>

<tr><td></td>
<td>Price: </td>
<td>${viewProduct.getPrice()}</td>
</tr>


<tr>
<td>

<input type="hidden" name="productId" value="${viewProduct.getProductId()}"/>
<input type="hidden" name="price" value="${viewProduct.getPrice()}"/>
<input type="hidden" name="productName" value="${viewProduct.getProductName()}"/>
<input type="hidden" name="userName" value="melan"/>
<input type="hidden" name="paymentStatus" value="NotPaid"/>
<button type="submit" class="btn btn-primary">Add To Cart</button>

</td>
</tr>

</table>
</form>
</body>
</html>