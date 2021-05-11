package com.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.bean.Employee;

public class Employee_dao {
	Connection con=null;
	PreparedStatement prst=null;
	ResultSet rs=null;
	public Employee_dao()
	{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
	
			e.printStackTrace();
		}
		try {
			con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE","system","1234");
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
		
	}
	
	
	public int getMaxId()
	{
		int id=1;
		if(con !=null)
		{
		
			try {
				prst = con.prepareStatement("select max(id) from employee");
				rs = prst.executeQuery();
				
				while(rs.next())
				{
					id = rs.getInt(1);
					id++;
				}
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			
			
		}else
		{
			System.out.println("ERROR in Database connection...");
		}
		return id;
	}
	public boolean InsertEmployee(Employee emp)
	{
		boolean isInserted=false;
		
		
		if(con != null)
		{
			
			try {
				prst = con.prepareStatement("insert into employee values(?,?,?,?,?)");
				prst.setInt(1, emp.getId());
				prst.setString(2, emp.getFname());
				prst.setString(3, emp.getLname());
				prst.setString(4, emp.getCity());
				prst.setInt(5, emp.getSalary());
			} catch (SQLException e) {
				
				e.printStackTrace();
			}
			try {
				int value=prst.executeUpdate();
				if(value!= 0)
				{
					isInserted=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else
		{
			System.out.println("ERROR in Database connection...");
		}
		return isInserted;
	}
	
	public ArrayList<Employee> getAllEmployees()
	{
		ArrayList<Employee> emp_list = new ArrayList<Employee>();
		
		if(con != null)
		{
			try {
				prst = con.prepareStatement("select * from employee");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs=prst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				while(rs.next())
				{
					Employee emp=new Employee(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getInt(5));
					emp_list.add(emp);
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
			
		}else
		{
			System.out.println("ERROR in Database connection...");
		}
		
		
		return emp_list;
	}

	public boolean Delete_employee(int id)
	{
		boolean isDeleted=false;
		
		if(con != null)
		{
			try {
				prst =con.prepareStatement("delete from employee where id=?");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prst.setInt(1, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				int i=prst.executeUpdate();
				if(i!=0) {
					isDeleted=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}else
		{
			System.out.println("ERROR in Database connection...");
		}
		
		return isDeleted;
	}
	public Employee getEmployeeById(int id)
	{
		Employee emp=new Employee();
		if(con!=null)
		{
			
			try {
				prst = con.prepareStatement("select * from employee where id=?");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				prst.setInt(1, id);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				rs = prst.executeQuery();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			try {
				while(rs.next())
				{
				emp.setId(rs.getInt(1));
				emp.setFname(rs.getString(2));
				emp.setLname(rs.getString(3));
				emp.setCity(rs.getString(4));
				emp.setSalary(rs.getInt(5));
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else
		{
			System.out.println("ERROR in Database connection...");
		}
		return emp;
	}
	
	
	public boolean UpdateEmployee(Employee emp)
	{
		boolean isUpdated=false;
		if(con!=null)
		{



			try {
				prst =con.prepareStatement( "UPDATE employee SET FIRST_NAME = ?, LAST_NAME = ?, CITY=?,SALARY=? WHERE id=?");
				prst.setString(1, emp.getFname());
				prst.setString(2, emp.getLname());
				prst.setString(3, emp.getCity());
				prst.setInt(4, emp.getSalary());
				prst.setInt(5, emp.getId());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			int value;
			try {
				value = prst.executeUpdate();
				if(value!= 0)
				{
					isUpdated=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}else
		{
			System.out.println("ERROR in Database connection...");
		}
		return isUpdated;
		
	}
}
