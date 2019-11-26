package idao;

import java.util.ArrayList;

import hotel.model.Room;

public interface IRoomDao {
	public  ArrayList<Room> getUserList();
	public int Insert(int id,String name,String phone,String settime,String livetime,int roomid);
	public int Updateforinsert(int id,int roomid);
	public int Updateforlive(int roomid);
}
