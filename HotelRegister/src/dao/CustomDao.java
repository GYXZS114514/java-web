package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hotel.model.Custom;
import idao.ICustomDao;
import util.DBBean;

public class CustomDao implements ICustomDao
{
	public CustomDao()
	{
		
	}
	public ArrayList<Custom> getUserList(String id)
	{
		ArrayList<Custom> list=new ArrayList<Custom>();
		String sql="select* from custom where id="+id; 
		DBBean jdbc=new DBBean(); 
		ResultSet rs=jdbc.executeQuery(sql);
		try{  
			while(rs.next())
			{ 
				Custom ui=new Custom(); 
				ui.setId(rs.getString("id"));
				ui.setName(rs.getString("name"));
				ui.setPhone(rs.getString("phone"));
				ui.setSettime(rs.getString("settime"));
				ui.setLivetime(rs.getString("livetime"));
				ui.setRoomid(Integer.valueOf(rs.getString("roomid")));
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
	public int updateforcustom(String customid,String name,String phone,String settime,String livetime,int roomid)
	{
		int result1;
		int intcus=Integer.valueOf(customid);
		String sql1="update custom set name='"+name+"',phone='"+phone+"',settime='"+settime+"',livetime='"+livetime+"',roomid='"+roomid+"'where id="+intcus;
		DBBean jdbc=new DBBean(); 
		result1=jdbc.executeUpdate(sql1);
		System.out.println("不是更新执行的问题");
		jdbc.close();
		return result1;
	}
	public ArrayList<Custom> getAlluser()
	{
		ArrayList<Custom> list=new ArrayList<Custom>();
		String sql="select* from custom "; 
		DBBean jdbc=new DBBean(); 
		ResultSet rs=jdbc.executeQuery(sql);
		try{  
			while(rs.next())
			{ 
				Custom ui=new Custom(); 
				ui.setId(rs.getString("id"));
				ui.setName(rs.getString("name"));
				ui.setPhone(rs.getString("phone"));
				ui.setSettime(rs.getString("settime"));
				ui.setLivetime(rs.getString("livetime"));
				ui.setRoomid(Integer.valueOf(rs.getString("roomid")));
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
	public void DeleteCustom(String id)
	{
		int cus=Integer.valueOf(id);
		Custom ui=new Custom(); 
		System.out.println(id+"\n");
		String sql1="delete from custom where id="+cus;
		String sql="select* from custom where id="+cus;
		DBBean jdbc=new DBBean(); 
		ResultSet rs=jdbc.executeQuery(sql);
		try{  
			while(rs.next())
			{ 
				
				ui.setId(rs.getString("id"));
				ui.setName(rs.getString("name"));
				ui.setPhone(rs.getString("phone"));
				ui.setSettime(rs.getString("settime"));
				ui.setLivetime(rs.getString("livetime"));
				ui.setRoomid(Integer.valueOf(rs.getString("roomid")));
			} 
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		} 
		RoomDao room=new RoomDao();
		int result=room.Updateforlive(ui.getRoomid());
		jdbc.executeQuery(sql1);
		jdbc.close();
	}
}
