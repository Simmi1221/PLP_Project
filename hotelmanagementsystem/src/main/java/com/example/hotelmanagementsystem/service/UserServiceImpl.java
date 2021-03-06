package com.example.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;
import com.example.hotelmanagementsystem.dao.UserDao;

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

}
