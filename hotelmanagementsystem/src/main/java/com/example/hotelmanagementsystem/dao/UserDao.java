package com.example.hotelmanagementsystem.dao;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;

public interface UserDao {
	
	public UserBean register(UserBean userBean);
	public UserBean login(String email,String password);
	public boolean bookingRoom(BookingInfoBean bookingInfoBean,int userId);

}
