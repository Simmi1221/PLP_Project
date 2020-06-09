package com.capgemini.onlinehotelbooking.service;

import java.util.Date;
import java.util.List;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.EmployeeInfoBean;
import com.capgemini.onlinehotelbooking.beans.HotelInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;

public interface AdminService {

	public boolean addHotel(HotelInfoBean hotelInfoBean);

	public boolean updateHotelDetails(HotelInfoBean hotelInfoBaan);

	public boolean deleteHotel(int hotelId);

	public List<HotelInfoBean> seeHotelDetails();

	public boolean addRoom(RoomInfoBean roomInfoBean);

	public boolean updateRoomDetails(RoomInfoBean roomInfoBean);

	public boolean deleteRoom(int roomId);

	public List<RoomInfoBean> seeRoomDetails();

	public List<BookingInfoBean> bookingListOfSpecificHotel(int hotelId);

	public List<BookingInfoBean> guestListOfSpecificHotel(int hotelId);

	public List<BookingInfoBean> bookingListOfSpecificDate(Date date);

	public EmployeeInfoBean addEmployee(EmployeeInfoBean employeeBean);

	public List<HotelInfoBean> searchHotel(String city);
}
