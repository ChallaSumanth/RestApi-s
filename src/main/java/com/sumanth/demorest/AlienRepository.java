package com.sumanth.demorest;

import java.util.ArrayList;
import java.util.List;
import java.sql.*;


public class AlienRepository {
	
	public Connection con = null;
	
	public AlienRepository()
	{
		String url = "jdbc:mysql://localhost:3306/restdb?characterEncoding=UTF-8";
		String username = "root";
		String pass = "root";
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection(url, username, pass);
			if(con != null) System.out.println("connection is not null...");
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	
	public List<Alien> getAliens()
	{
		List<Alien> aliens = new ArrayList<Alien>();
		String sql = "select * from alien";
		try
		{
			
				Statement st = con.createStatement();
				ResultSet re = st.executeQuery(sql);
				while(re.next())
				{
					Alien a = new Alien();
					a.setId(re.getInt(1));
					a.setName(re.getString(2));
					a.setPoints(re.getInt(3));
					aliens.add(a);
				}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return aliens;
	}
	
	public Alien getAlien(int id)
	{
		//Alien a1 = null;
		Alien a = new Alien();
		String sql = "select * from alien where id ="+id;
		try
		{
			
				Statement st = con.createStatement();
				ResultSet re = st.executeQuery(sql);
				while(re.next())
				{
					a.setId(re.getInt(1));
					a.setName(re.getString(2));
					a.setPoints(re.getInt(3));
					//aliens.add(a);
				}
			
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
		return a;
	}
	public void create(Alien a1)
	{
		String sql = "insert into alien values (?,?,?)";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, a1.getId());
			st.setString(2, a1.getName());
			st.setInt(3, a1.getPoints());
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void update(Alien a1)
	{
		String sql = "update alien set name=?, points=? where id=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, a1.getName());
			st.setInt(2, a1.getPoints());
			st.setInt(3, a1.getId());
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
	public void delete(int id)
	{
		String sql = "delete from alien where id=?";
		try
		{
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			st.executeUpdate();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}
}
