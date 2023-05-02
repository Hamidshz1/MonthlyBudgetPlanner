<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title> 
 <%@ include file="../componenti/css.jsp" %>

</head>
<body>
<%@include file="../componenti/navbar.jsp" %>
<div class="container">
<div class="row">
<div class="col-md-4 offset-md-4">
<div class="card">
<div class="card-header text-center">
<P class="fs-3">Add Expense</P>
</div>
<div class="card-body">
<form action=""method="get">
<div class="mb-3">
<label>Title</label> <input type="text" name="title"
class="form-control">
</div>
<div class="mb-3">
<label>Date</label> <input type="date" name="date"
class="form-control">
</div>
<div class="mb-3">
<label>Time</label> <input type="date" name="date"
class="form-control">
</div>
<div class="mb-3">
<label>Desciption</label> <input type="text" name="desciprion"
class="form-control">
</div>
<div class="mb-3">
<label>Price</label> <input type="text" name="price"
class="form-control">
</div>
<button class="btn btn-success col-md-12">Add</button>
</form>
</body>
</html>