package hotel.model;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import util.DBBean;

public class Custom 
{
	private String id;
	private String name;
	private String phone;
	private String setime;
	private String livetime;
	private int roomid;
	public void setId(String id)
	{
		this.id=id;
	}
	public String getId()
	{
		return id;
	}
	public void setName(String name)
	{
		this.name=name;
	}
	public String getName()
	{
		return name;
	}
	public void setPhone(String phone)
	{
		this.phone=phone;
	}
	public String getPhone()
	{
		return phone;
	}
	public void setSettime(String settime)
	{
		this.setime=settime;
	}
	public String getSettime()
	{
		return setime;
	}
	public void setLivetime(String livetime)
	{
		this.livetime=livetime;
	}
	public String getLivetime()
	{
		return livetime;
	}
	public void setRoomid(int roomid)
	{
		this.roomid=roomid;
	}
	public int getRoomid()
	{
		return roomid;
	}
}
