package com.example.hotelmanagementsystem.dao;

import java.util.Date;
import java.util.List;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.HotelInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserDetailsBean;

public interface AdminDao {
	
	public boolean addHotel(HotelInfoBean hotelInfoBean);
	public boolean updateHotelDetails(HotelInfoBean hotelInfoBaan);
	public boolean deleteHotel(int hotelId);
	public List<HotelInfoBean> seeHotelDetails();
	public boolean addRoom(RoomInfoBean roomInfoBean);
	public boolean updateRoomDetails(RoomInfoBean roomInfoBean);
	public boolean deleteRoom(int roomId);
	public List<BookingInfoBean> bookingListOfSpecificHotel(int hotelId);
	public List<UserDetailsBean> guestListOfSpecificHotel(int hotelId);
	public List<BookingInfoBean> bookingListOfSpecificDate(Date date);
}
