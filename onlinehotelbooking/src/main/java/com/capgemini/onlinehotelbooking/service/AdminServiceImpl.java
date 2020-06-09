package com.capgemini.onlinehotelbooking.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.EmployeeInfoBean;
import com.capgemini.onlinehotelbooking.beans.HotelInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;
import com.capgemini.onlinehotelbooking.dao.AdminDao;

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
	public List<BookingInfoBean> bookingListOfSpecificDate(Date date) {
		return dao.bookingListOfSpecificDate(date);
	}

	@Override
	public  EmployeeInfoBean addEmployee(EmployeeInfoBean employeeBean) {
		return dao.addEmployee(employeeBean);
	}

	@Override
	public List<HotelInfoBean> searchHotel(String city) {
		return dao.searchHotel(city);
	}


}
