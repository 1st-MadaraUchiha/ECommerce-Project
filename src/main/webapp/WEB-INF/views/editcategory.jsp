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
	<h2>Add Category</h2>
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js"
		integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2"
		crossorigin="anonymous"></script>
	<form action="<c:url value="/editedCategory"/>" method="post">
		<table class="table">
			<thead>
				<tr>
					<th scope="col"></th>
					<th scope="col">Id</th>
					<th scope="col">Category Name</th>
					<th scope="col">Category Description</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row"></th>
					<th scope="row"><input type="text" name="categoryId"
						value="${lists.categoryId}" readonly="readonly"></th>
					<th scope="col"><input type="text" name="categoryName"
						id="catAdd" placeholder="Enter Category Name" required>${lists.categoryName}</th>
					<th scope="col"><input type="text" name="categoryDesc"
						id="catDesc" paceholder="Enter Category Description" required>${lists.categoryDesc}</th>

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
