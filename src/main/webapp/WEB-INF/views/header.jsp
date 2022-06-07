<%@page import="Fashion.Model.User"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	<%@page isELIgnored="false" %>
<nav class="navbar navbar-expand-lg navbar-light bg-light">

	<div class="collapse navbar-collapse" id="navbarSupportedContent">
		<ul class="navbar-nav mr-auto">
			<li class="nav-item active"><a class="nav-link" href="<c:url value="/Home"/>">Home</a>
			</li>
			<li class="nav-item active"><a class="nav-link" href="<c:url value="/Login"/>">Login</a>
			</li>
			<li class="nav-item"><a class="nav-link" href="<c:url value="/Register"/>">Register</a>
			</li>

			<li class="nav-item"><a class="nav-link" href="<c:url value="/ContactUs"/>">Contact
					Us</a></li>
			<li class="nav-item active"><a class="nav-link" href="<c:url value="/AboutUs"/>">About
					Us</a></li>
		
		
	 	<% User user = (User) session.getAttribute("role");
			if(user.getRole().equals("admin")){
		%> 
		
			<li class="nav-item"><a class="nav-link" href="<c:url value="/AddProduct"/>">Manage Product</a></li>
			<li class="nav-item active"><a class="nav-link" href="<c:url value="/AddCategory"/>">Manage Category</a></li>

			 <% } %> 
			 
			 <%if(user.getRole().equals("normal")){ %>
			 <li class="nav-item active"><a class="nav-link" href="<c:url value="/Cart"/>">Cart</a></li>
			 
			 
			 <%} %>

			<li class="nav-item"><a class="nav-link" href="<c:url value="/LogOut"/>">LogOut</a></li>
		</ul>
		<form class="form-inline my-2 my-lg-0">
			<input class="form-control mr-sm-2" type="search"
				placeholder="Search" aria-label="Search">
			<button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
		</form>
	</div>
</nav>