<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page
	import="com.dao.Employee_dao,com.bean.Employee,java.util.ArrayList"%>
<!DOCTYPE html>
<html>
<head>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-wEmeIV1mKuiNpC+IOBjI7aAzPcEZeedi5yW5f2yOq55WWLwNGmvvx4Um1vskeMj0" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>View Employees</title>
</head>
<body>
<%@ include file="index.html" %>
	<table border="1"  class="table table-striped">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>City</th>
			<th>Salary</th>
			<th>Action</th>
		</tr>
		<%
		

ArrayList<Employee> employees = new Employee_dao().getAllEmployees();

for(Employee emp : employees)
{
%>
		<tr>
		<td><%= emp.getId() %></td>
		<td><%= emp.getFname() %></td>
		<td><%= emp.getLname() %></td>
		<td><%= emp.getCity() %></td>
		<td><%= emp.getSalary() %></td>
		<td> <a href="Edit_Employee.jsp?id=<%= emp.getId()  %>""#">Edit </a> / <a href="deleteEmployee?id=<%= emp.getId()  %>">Delete</td>
			</tr>
			
			<% 
	}

%>
	</table>
</body>
</html>