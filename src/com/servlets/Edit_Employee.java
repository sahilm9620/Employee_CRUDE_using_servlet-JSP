package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.bean.Employee;
import com.dao.Employee_dao;


public class Edit_Employee extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int salary =Integer.parseInt( request.getParameter("salary"));
		String city = request.getParameter("city");
		Employee_dao emp_dao=new Employee_dao();
		Employee emp=new Employee(id,fname,lname,city,salary);
		if(emp_dao.UpdateEmployee(emp))
		{
			out.println("<h4 style='color:green'> Employee Updated successfully...");
			request.getRequestDispatcher("View_Emp.jsp").include(request,response);
		}else
		{
			out.println("<h4 style='color:red'> ERROR..!!");
		}
		
		
	}

}
