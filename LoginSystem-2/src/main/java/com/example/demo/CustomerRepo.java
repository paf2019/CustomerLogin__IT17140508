package com.example.demo;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;

public class CustomerRepo {
	List<CustomerDetails> customers;
	
	Connection con=null;
	
	public CustomerRepo()
	{
		customers=new ArrayList<>();
	
		/*
		CustomerDetails a1=new CustomerDetails();
		a1.setName("Pam");
		//a1.setPoints(50);
		a1.setId(10);
		
		CustomerDetails a2=new CustomerDetails();
		a2.setName("Pamal");
		//a2.setPoints(500);
		a2.setId(100);
		
		CustomerDetails a3=new CustomerDetails();
		a3.setName("Kasun");
		//a1.setPoints(50);
		a3.setId(10);
		
		customers.add(a1);
		customers.add(a2);
		customers.add(a3);
		*/
		
		
		String url="jdbc:mysql://localhost:3306/shoppingdb";
		String uname="root";
		String pwd="root";
		
		try {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			con=DriverManager.getConnection(url,uname,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void create(CustomerDetails c1)
	{
		customers.add(c1);
	}

	public List<CustomerDetails> getCustomers()
	{
		List<CustomerDetails> customers=new ArrayList<>();
		
		customers=new ArrayList<>();
		CustomerDetails a1=new CustomerDetails();
		a1.setName("Pam");
		//a1.setPoints(50);
		a1.setId(10);
		
		CustomerDetails a2=new CustomerDetails();
		a2.setName("Pamal");
		//a2.setPoints(500);
		a2.setId(100);
		
		CustomerDetails a3=new CustomerDetails();
		a3.setName("Kasun");
		//a1.setPoints(50);
		a3.setId(10);
		
		customers.add(a1);
		customers.add(a2);
		customers.add(a3);
		
		/*
		String sql="select * from customers";
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			while(rs.next())
			{
				CustomerDetails c=new CustomerDetails();
				c.setId(rs.getInt(1));
				
				
				customers.add(c);
			}		
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		*/		
		return customers;
	}
	
	
	public CustomerDetails getCustomer(int id)
	{
		
		//List<CustomerDetails> customers=new ArrayList<>();
		
		String sql="select * from customers where id="+id;
		CustomerDetails c=new CustomerDetails();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next())
			{		
				c.setId(rs.getInt(1));			
				customers.add(c);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return c;
		
		/*CustomerDetails c1=null;
		
		for(CustomerDetails c:customers)
		{
			if(c.getId()==id)
			{
				return c;
			}
		}*/
		
	}
	
	
	public List<CustomerDetails> getCustomers1()
	{
List<CustomerDetails> customers=new ArrayList<>();
		
		String sql="select * from customers";
		CustomerDetails c=new CustomerDetails();
		try {
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery(sql);
			
			if(rs.next())
			{		
				c.setId(rs.getInt(1));			
				customers.add(c);
			}			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
		return customers;
	}
	
	
	public void create1(CustomerDetails c)
	{

		String sql="insert into customers values (?)";
		CustomerDetails c1=new CustomerDetails();
		try {
			PreparedStatement st=con.prepareStatement(sql);
			st.setInt(1, c.getId());
			st.executeUpdate();
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			e.printStackTrace();
		}
	}
}
