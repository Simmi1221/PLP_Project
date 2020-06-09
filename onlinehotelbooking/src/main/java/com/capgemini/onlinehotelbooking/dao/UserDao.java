package com.capgemini.onlinehotelbooking.dao;

import java.util.Date;
import java.util.List;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.EmployeeInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;

public interface UserDao {

	public UserBean register(UserBean userBean);

	public UserBean login(String email, String password);

	public EmployeeInfoBean loginAsEmployee(String email, String password);

	public boolean bookingRoom(BookingInfoBean bookingInfoBean, int userId);

	public long getdays(Date startDate, Date endDate);

	public List<RoomInfoBean> seeRoomDetails(int hotelId);

	public boolean updateProfile(int userId, UserBean userBean);

	public UserBean getUserProfile(int userId);

	public double getBill(int userId);

	public List<RoomInfoBean> seeRoomDetailsForEmployee(int hotelId);

	public boolean bookingRoomByEmployee(BookingInfoBean bookingInfoBean);
	
	public boolean updateBookingInfoBean(BookingInfoBean bookingInfoBean,int userId);

}
