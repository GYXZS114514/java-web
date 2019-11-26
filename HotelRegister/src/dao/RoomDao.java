package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotel.model.Room;
import idao.IRoomDao;
import util.DBBean;
public class RoomDao implements IRoomDao
{
	public RoomDao()
	{
		
	}
	public  ArrayList<Room> getUserList()
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
	public int Insert(int id,String name,String phone,String settime,String livetime,int roomid)
	{
		String sql="select* from room where id="+roomid; 
		DBBean jdbc=new DBBean();
		int result=0;
		ResultSet rs=jdbc.executeQuery(sql);
		try{  
			while(rs.next())
			{ 
				if(rs.getString("isempty").equals("0"))
				{
					String sql1="insert into custom values('"+id+"','"+name+"','"+phone+"','"+settime+"','"+livetime+"','"+roomid+"')";
					DBBean jdbc1=new DBBean(); 
				    jdbc1.executeUpdate(sql1);
					jdbc1.close();
					result=1;
				}
			} 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		jdbc.close();
		return result;
	}
	public int Updateforinsert(int id,int roomid)
	{
		int result1;
		String isempty="1";
		String sql1="update room set isempty='"+isempty+"',customid='"+id+"'where id="+roomid;
		DBBean jdbc=new DBBean(); 
		result1=jdbc.executeUpdate(sql1);
		jdbc.close();
		return result1;
	}
	public int Updateforcustom(String id,int roomid,int lastroom)
	{
		int result1;
		String isempty="1";
		String isem="0";
		String sql="update room set isempty='"+isem+"',customid='"+isem+"'where id="+lastroom;
		String sql1="update room set isempty='"+isempty+"',customid='"+id+"'where id="+roomid;
		DBBean jdbc=new DBBean(); 
		result1=jdbc.executeUpdate(sql1);
		jdbc.close();
		DBBean jdbc1=new DBBean();
		jdbc1.executeUpdate(sql);
		jdbc1.close();
		return result1;
	}
	public int Updateforlive(int roomid)
	{

		int result1;
		String isempty="0";
		String id="0";
		String sql1="update room set isempty='"+isempty+"',customid='"+id+"'where id="+roomid;
		DBBean jdbc=new DBBean(); 
		result1=jdbc.executeUpdate(sql1);
		jdbc.close();
		return result1;
	}
}
