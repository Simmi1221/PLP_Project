package com.example.hotelmanagementsystem.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseBean {

	private int statusCode;
	private String message;
	private String description;
	private HotelInfoBean hotelInfoBean;
	private List<HotelInfoBean> hotelList;
	private BookingInfoBean bookingInfoBean;
	private List<BookingInfoBean> bookingList;
	private UserDetailsBean usrDetailsBean;
	private List<UserDetailsBean> userList;

	// Getters and Setters
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

	public UserDetailsBean getUsrDetailsBean() {
		return usrDetailsBean;
	}

	public void setUsrDetailsBean(UserDetailsBean usrDetailsBean) {
		this.usrDetailsBean = usrDetailsBean;
	}

	public List<UserDetailsBean> getUserList() {
		return userList;
	}

	public void setUserList(List<UserDetailsBean> userList) {
		this.userList = userList;
	}

}
