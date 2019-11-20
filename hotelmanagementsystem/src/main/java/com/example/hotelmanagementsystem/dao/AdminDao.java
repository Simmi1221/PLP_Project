package com.example.hotelmanagementsystem.dao;

import java.time.LocalDate;
import java.util.List;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.HotelInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;

public interface AdminDao {

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

	public List<BookingInfoBean> bookingListOfSpecificDate(LocalDate date);
	
	public UserBean addEmployee(UserBean userBean);
}
