package com.capgemini.onlinehotelbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.EmployeeInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;
import com.capgemini.onlinehotelbooking.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao dao;

	@Override
	public UserBean register(UserBean userBean) {
		return dao.register(userBean);
	}
	
	@Override
	public UserBean login(String email, String password) {
		return dao.login(email, password);
	}
	
	@Override
	public boolean bookingRoom(BookingInfoBean bookingInfoBean, int userId) {
		return dao.bookingRoom(bookingInfoBean, userId);
	}

	@Override
	public List<RoomInfoBean> seeRoomDetails(int hotelId) {
		return dao.seeRoomDetails(hotelId);
	}

	@Override
	public boolean updateProfile(int userId, UserBean userBean) {
		return dao.updateProfile(userId, userBean);
	}

	@Override
	public UserBean getUserProfile(int userId) {
		return dao.getUserProfile(userId);
	}

	@Override
	public double getBill(int userId) {
		return dao.getBill(userId);
	}

	@Override
	public EmployeeInfoBean loginAsEmployee(String email, String password) {
		return dao.loginAsEmployee(email, password);
	}

	@Override
	public List<RoomInfoBean> seeRoomDetailsForEmployee(int hotelId) {
		return dao.seeRoomDetailsForEmployee(hotelId);
	}

	@Override
	public boolean bookingRoomByEmployee(BookingInfoBean bookingInfoBean) {
		return dao.bookingRoomByEmployee(bookingInfoBean);
	}

	@Override
	public boolean updateBookingInfoBean(BookingInfoBean bookingInfoBean,int userId) {
		return dao.updateBookingInfoBean(bookingInfoBean,userId);
	}

}
