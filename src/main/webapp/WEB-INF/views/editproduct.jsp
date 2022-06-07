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
	<h2>Edit Product</h2>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
	<form action="<c:url value="/editedProduct"/>" method="post" enctype="multipart/form-data">
		<table class="table">
			<thead>
		
				<tr>
				<th scope="col"></th>
				<th scope="col">Product Id</th>
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
					<th scope="row"><input type="text" name="productId" value="${product.productId}" readonly="readonly"></th>
					<th scope="col"><input type="text" name="productName" 	 id="productName"  placeholder="Enter Product Name" required><br>${product.productName}</th>
					<th scope="col"><input type="text" name="productDesc"   id="productDesc" placeholder="Enter Product Description" required><br>${product.productDesc}</th>
					<th scope="col"><input type="number" name="price"   id="price" placeholder="Enter Product Price" required><br>${product.price}</th>
					<th scope="col"><input type="number" name="stock"   id="stock" placeholder="Enter Product Stock" required><br>${product.stock}</th>
					<th scope="col"><input type="number" name="categoryId" id="categoryId" placeholder="Enter Product Category" required><br>${product.categoryId}</th>
					<th scope="col"><input type="text" name="supplierId"   id="supplierId" placeholder="Enter Product Supplier" required><br>${product.supplierId}</th>
					<th scope="col"><input type="file" name="image"   id="image" required>${image}</th>
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


</body>
</html>
