<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Register</title>
<%@include file="componenti/css.jsp"%>
<style type="text/css">
.card.sh {
	box-shadow: 0 0 6px 0 rgba(0, 0, 0, 0.3);
}
</style>
</head>
<body class="bg-light">
	<%@include file="componenti/navbar.jsp"%>
	<div class="container p-5">
		<style>
.container {
	position: absolute;
	top: 50%;
	left: 50%;
	transform: translate(-50%, -50%);
}
</style>
		<div class="row">

			<div class="col-md-6 offset-md-3">
				<div class="card card-sh">
					<div class="card-header">
						<p class="text-center fs-3">Register Form</p>
						<c:if test="${not empty msg}">
							<p class="text-center fs-3">${msg}</p>
							<c:remove var="msg" />
						</c:if>


					</div>
					<div class="card-body">
						<form action="register" method="post">
							<div class="mb-3">
								<label>Username</label> <input type="text" name="username"
									class="form-control">

							</div>
							<div class="mb-3">
								<label>Password</label> <input type="password" name="password"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>First Name</label> <input type="text" name="firstname"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Last Name</label> <input type="text" name="lastname"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Email</label> <input type="email" name="email"
									class="form-control">
							</div>
							<div class="mb-3">
								<label>Age</label> <input type="number" name="age"
									class="form-control">
							</div>
							<button class="btn btn-dark col-md-12">Register</button>

						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
