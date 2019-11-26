package hotel.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBBean;

public class Room 
{
	private int id;
	private int isempty;
	private int customid;
	private String price;
	private String livetime;
	public void setID(int id)
	{
		this.id=id;
	}
	public int getID()
	{
		return id;
	}
	public void setIsempty(int isempty)
	{
		this.isempty=isempty;
	}
	public int getIsempty()
	{
		return isempty;
	}
	public void setCustomid(int customid)
	{
		this.customid=customid;
	}
	public int getCustomid()
	{
		return customid;
	}
	public void setPrice(String price)
	{
		this.price=price;
	}
	public String getPrice()
	{
		return price;
	}
	public void setLivetime(String livetime)
	{
		this.livetime=livetime;
	}
	public String getLivetime()
	{
		return livetime;
	}
	public static ArrayList<Room> getUserList()
	{
		ArrayList<Room> list=new ArrayList<Room>();
		String sql="select* from room"; 
		DBBean jdbc=new DBBean(); 
		ResultSet rs=jdbc.executeQuery(sql);
		try{  
			while(rs.next())
			{ 
				Room ui=new Room(); 
				ui.setIsempty(Integer.valueOf(rs.getString("isempty")));
				if(rs.getString("customid")!=null)
				{
					ui.setCustomid(Integer.valueOf(rs.getString("customid"))); 
				}
				ui.setPrice(rs.getString("price")); 
				list.add(ui); 
			} 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		jdbc.close();
		return list;
	}
}
