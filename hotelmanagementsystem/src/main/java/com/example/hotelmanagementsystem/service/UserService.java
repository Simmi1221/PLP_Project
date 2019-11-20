package com.example.hotelmanagementsystem.service;

import java.util.List;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;

public interface UserService {
	
	public UserBean register(UserBean userBean);
	public UserBean login(String email,String password);
	public boolean bookingRoom(BookingInfoBean bookingInfoBean,int userId);
	public List<RoomInfoBean> seeRoomDetails(int hotelId);
	public boolean updateProfile(int userId,UserBean userBean);
	public UserBean getUserProfile(int userId);
}
