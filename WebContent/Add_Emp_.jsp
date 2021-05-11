<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">

<title>Add Employee</title>
</head>
<body>
<%@ include file="index.html" %>

<form action="AddempServlet" method="post" align='center'>
<table class="table table-striped">
<tr>
<th colspan='2'> ADD EMPLOYEES</th>
</tr>
<tr><td>
<label> FIRST NAME : </label>
</td><td>
<input type="text" name="fname" class="form-label"> </td>
</tr>
<tr><td>
<label> LAST NAME : </label>
</td><td>
<input type="text" name="lname" class="form-label"> 
</td></tr>
<tr><td>
<label> SALARY : </label>
</td><td>
<input type="text" name="salary" class="form-label"> 
</td></tr>
<tr><td>
<label> CITY : </label>
</td><td>
<input type="text" name="city" class="form-label"> 
</td></tr>
<tr><td colspan='3'>
<input type="submit" value="ADD EMPLOYEE" class="btn btn-primary">
</td></tr>
 </table>
</form>
</body>
</html>