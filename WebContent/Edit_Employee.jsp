<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<%@ page import="com.dao.Employee_dao,com.bean.Employee" %>
<title>Edit Employee Details</title>
</head>
<body>
<%@ include file="index.html" %>

<form action="editEmployee" method="post" align='center'>
<table class="table table-striped">
<tr>
<th colspan='2'> UPDATE EMPLOYEES </th>
</tr>
<% 
int id =Integer.parseInt(request.getParameter("id"));
Employee emp=new Employee_dao().getEmployeeById(id) ; %>
<input type="hidden" name='id' value=<%= emp.getId() %>>
<tr><td>
<label> FIRST NAME : </label>
</td><td>
<input type="text" name="fname" class="form-label" value=<%= emp.getFname() %> > </td>
</tr>
<tr><td>
<label> LAST NAME : </label>
</td><td>
<input type="text" name="lname" class="form-label" value=<%= emp.getLname() %>> 
</td></tr>
<tr><td>
<label> SALARY : </label>
</td><td>
<input type="text" name="salary" class="form-label" value=<%= emp.getSalary() %>> 
</td></tr>
<tr><td>
<label> CITY : </label>
</td><td>
<input type="text" name="city" class="form-label" value=<%= emp.getCity() %>> 
</td></tr>
<tr><td colspan='3'>
<input type="submit" value="UPDATE EMPLOYEE" class="btn btn-primary">
</td></tr>
 </table>
</form>
</body>
</html>