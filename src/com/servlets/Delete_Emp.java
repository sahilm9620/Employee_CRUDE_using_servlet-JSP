package com.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.dao.Employee_dao;


public class Delete_Emp extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		response.setContentType("text/html");
		int id=Integer.parseInt(request.getParameter("id"));
		if(new Employee_dao().Delete_employee(id))
		{
			out.println("<h4 style='color:green'> Employee Deleted Successfully...");
			request.getRequestDispatcher("View_Emp.jsp").include(request, response);
			
		}else
		{
			out.println("<h4 style='color:red'> Error...!!");
			request.getRequestDispatcher("View_Emp.jsp").include(request, response);
		}
		
	}

}
