package idao;

import java.util.ArrayList;

import hotel.model.Custom;

public interface ICustomDao {
	public ArrayList<Custom> getUserList(String id);
	public ArrayList<Custom> getAlluser();
	public int updateforcustom(String customid,String name,String phone,String settime,String livetime,int roomid);
}
