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
	<form action="<c:url value="/catAdd"/>" method="post">
		<table class="table">
			<thead>
				<tr>
					<th scope="col"></th>
					<th scope="col">Category Name</th>
					<th scope="col">Category Description</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<th scope="row"></th>
					<th scope="col"><input required type="text" name="categoryName"
						class="form-control" id="catAdd" aria-describedby="emailHelp"
						placeholder="Enter Category Name"></th>
					<th scope="col"><input required type="text" name="categoryDesc"
						class="form-control" id="catDesc" aria-describedby="emailHelp"
						placeholder="Enter Category Description"></th>

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
				<th scope="col">Category Name</th>
				<th scope="col">Category Description</th>
				<th scope="col">Operations</th>

			</tr>
		</thead>
		<tbody>
			<c:forEach items="${lists}" var="l">
				<tr>
					<th scope="row"></th>
					<th scope="col"><c:out value="${l.getCategoryName()}" /></th>
					<th scope="col"><c:out value="${l.getCategoryDesc()}" /></th>
					<th scope="col"><a
						href="<c:url value="editCategory/${l.getCategoryId()}"/>"
						class="btn btn-primary">Edit</a></th>
					<th scope="col"><a
						href="<c:url value="deleteCategory/${l.getCategoryId()}"/>"
						class="btn btn-danger">Delete</a></th>
				</tr>
			</c:forEach>
		</tbody>
	</table>

</body>
</html>
