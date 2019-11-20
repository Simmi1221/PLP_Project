package com.example.hotelmanagementsystem.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.HotelInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;
import com.example.hotelmanagementsystem.dao.AdminDao;

@Service
public class AdminServiceImpl implements AdminService {

	@Autowired
	private AdminDao dao;

	@Override
	public boolean addHotel(HotelInfoBean hotelInfoBean) {
		return dao.addHotel(hotelInfoBean);
	}

	@Override
	public boolean updateHotelDetails(HotelInfoBean hotelInfoBaan) {
		return dao.updateHotelDetails(hotelInfoBaan);
	}

	@Override
	public boolean deleteHotel(int hotelId) {
		return dao.deleteHotel(hotelId);
	}

	@Override
	public List<HotelInfoBean> seeHotelDetails() {
		return dao.seeHotelDetails();
	}

	@Override
	public boolean addRoom(RoomInfoBean roomInfoBean) {
		return dao.addRoom(roomInfoBean);
	}

	@Override
	public boolean updateRoomDetails(RoomInfoBean roomInfoBean) {
		return dao.updateRoomDetails(roomInfoBean);
	}

	@Override
	public boolean deleteRoom(int roomId) {
		return dao.deleteRoom(roomId);
	}

	@Override
	public List<RoomInfoBean> seeRoomDetails() {
		return dao.seeRoomDetails();
	}

	@Override
	public List<BookingInfoBean> bookingListOfSpecificHotel(int hotelId) {
		return dao.bookingListOfSpecificHotel(hotelId);
	}

	@Override
	public List<BookingInfoBean> guestListOfSpecificHotel(int hotelId) {
		return dao.guestListOfSpecificHotel(hotelId);
	}

	@Override
	public List<BookingInfoBean> bookingListOfSpecificDate(LocalDate date) {
		return dao.bookingListOfSpecificDate(date);
	}

	@Override
	public UserBean addEmployee(UserBean userBean) {
		return dao.addEmployee(userBean);
	}

}
