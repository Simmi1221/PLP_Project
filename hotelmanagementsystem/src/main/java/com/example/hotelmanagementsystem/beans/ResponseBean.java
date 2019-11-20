package com.example.hotelmanagementsystem.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseBean {

	private int statusCode;
	private String message;
	private String description;
	private String userType;
	private HotelInfoBean hotelInfoBean;
	private List<HotelInfoBean> hotelList;
	private BookingInfoBean bookingInfoBean;
	private List<BookingInfoBean> bookingList;
	private UserBean userBean;
	private List<UserBean> userList;
	private List<RoomInfoBean> roomList;

	// Getters and Setters
	public List<RoomInfoBean> getRoomList() {
		return roomList;
	}

	public void setRoomList(List<RoomInfoBean> roomList) {
		this.roomList = roomList;
	}

	public List<UserBean> getUserList() {
		return userList;
	}

	public UserBean getUserBean() {
		return userBean;
	}

	public void setUserBean(UserBean userBean) {
		this.userBean = userBean;
	}

	public void setUserList(List<UserBean> userList) {
		this.userList = userList;
	}

	public void setBookingList(List<BookingInfoBean> bookingList) {
		this.bookingList = bookingList;
	}

	public int getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(int statusCode) {
		this.statusCode = statusCode;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getUserType() {
		return userType;
	}

	public void setUserType(String userType) {
		this.userType = userType;
	}

	public HotelInfoBean getHotelInfoBean() {
		return hotelInfoBean;
	}

	public void setHotelInfoBean(HotelInfoBean hotelInfoBean) {
		this.hotelInfoBean = hotelInfoBean;
	}

	public List<HotelInfoBean> getHotelList() {
		return hotelList;
	}

	public void setHotelList(List<HotelInfoBean> hotelList) {
		this.hotelList = hotelList;
	}

	public BookingInfoBean getBookingInfoBean() {
		return bookingInfoBean;
	}

	public void setBookingInfoBean(BookingInfoBean bookingInfoBean) {
		this.bookingInfoBean = bookingInfoBean;
	}

	public List<BookingInfoBean> getBookingList() {
		return bookingList;
	}

	public void setBoookingList(List<BookingInfoBean> bookingList) {
		this.bookingList = bookingList;
	}

}
