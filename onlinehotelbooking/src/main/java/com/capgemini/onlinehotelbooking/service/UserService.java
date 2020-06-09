package com.capgemini.onlinehotelbooking.service;

import java.util.List;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.EmployeeInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;

public interface UserService {

	public UserBean register(UserBean userBean);

	public UserBean login(String email, String password);

	public EmployeeInfoBean loginAsEmployee(String email, String password);

	public boolean bookingRoom(BookingInfoBean bookingInfoBean, int userId);

	public List<RoomInfoBean> seeRoomDetails(int hotelId);

	public boolean updateProfile(int userId, UserBean userBean);

	public UserBean getUserProfile(int userId);

	public double getBill(int userId);

	public List<RoomInfoBean> seeRoomDetailsForEmployee(int hotelId);

	public boolean bookingRoomByEmployee(BookingInfoBean bookingInfoBean);
	
	public boolean updateBookingInfoBean(BookingInfoBean bookingInfoBean,int userId);

}
