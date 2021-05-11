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


public class Add_Emp_Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		response.setContentType("text/html");
		String fname = request.getParameter("fname");
		String lname = request.getParameter("lname");
		int salary =Integer.parseInt( request.getParameter("salary"));
		String city = request.getParameter("city");
		Employee_dao emp_dao=new Employee_dao();
		Employee emp=new Employee(emp_dao.getMaxId(),fname,lname,city,salary);
		if(emp_dao.InsertEmployee(emp))
		{
			out.println("<h4 style='color:green'> Employee added successfully...");
			request.getRequestDispatcher("Add_Emp_.jsp").include(request,response);
		}else
		{
			out.println("<h4 style='color:red'> ERROR..!!");
		}
		
	}

}
