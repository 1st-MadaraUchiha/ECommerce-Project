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

</head>
<body>
	<h2>Add Product</h2>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
	<form action="<c:url value="/saveFile"/>" method="post" enctype="multipart/form-data">  
		<table class="table">
			<thead>
				<tr>
					<th scope="col"></th>
					<th scope="col">Product Name</th>
					<th scope="col">Product Description</th>
					<th scope="col">Product Price</th>
					<th scope="col">Product Stock</th>
					<th scope="col">Category</th>
					<th scope="col">Supplier</th>
					<th scope="col">Product Image</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row"></th>
					<th scope="col"><input required type="text" name="productName"
						placeholder="Enter Product Name"></th>
					<th scope="col"><input required type="text" name="productDesc"
						placeholder="Enter Product Description"></th>
					<th scope="col"><input required type="text" name="price"
						placeholder="Enter Product Price"></th>
					<th scope="col"><input required type="text" name="stock"
						placeholder="Enter Product Stock"></th>
					<th scope="col"><input required type="text" name="categoryId"
						placeholder="Enter Category Id"></th>
					<th scope="col"><input required type="text" name="supplierId"
						placeholder="Enter Supplier Id"></th>
					<th scope="col"><input required type="file" name="image" id="image" /></th>
				</tr>
				<tr>
					<th scope="row"></th>
					<th scope="col">
						<button type="submit" class="btn btn-primary">Submit</button>
					</th>
				</tr>
				<tr>
					<th></th>
					<th></th>
					<th></th>
				</tr>

			</tbody>
		</table>
	</form>

	<table class="table">
		<thead>
			<tr>
				<th scope="col"></th>
				<th scope="col">Product Name</th>
				<th scope="col">Product Description</th>
				<th scope="col">Product Price</th>
				<th scope="col">Product Stock</th>
				<th scope="col">Category</th>
				<th scope="col">Supplier</th>
				<th scope="col">Product Image</th>
				<th scope="col">Operations</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${pro}" var="p">
				<tr>
					<th scope="row"></th>
					<th scope="col"><c:out value="${p.productName}" /></th>
					<th scope="col"><c:out value="${p.productDesc}" /></th>
					<th scope="col"><c:out value="${p.price}" /></th>
					<th scope="col"><c:out value="${p.stock}" /></th>
					<th scope="col"><c:out value="${p.categoryId}" /></th>
					<th scope="col"><c:out value="${p.supplierId}" /></th>
					<th scope="col"><img src="/${p.getProductId()}.jpg"/></th>
					<th scope="col"><a
						href="<c:url value="editProduct/${p.getProductId()}"/>"
						class="btn btn-primary">Edit</a></th>
					<th scope="col"><a
						href="<c:url value="deleteProduct/${p.getProductId()}"/>"
						class="btn btn-danger">Delete</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>
