package com.capgemini.onlinehotelbooking.beans;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class ResponseBean {

	private int statusCode;
	private String message;
	private String description;
	private String userType;
	private String employeeType;
	private HotelInfoBean hotelInfoBean;
	private List<HotelInfoBean> hotelList;
	private BookingInfoBean bookingInfoBean;
	private List<BookingInfoBean> bookingList;
	private UserBean userBean;
	private List<UserBean> userList;
	private List<RoomInfoBean> roomList;
	private EmployeeInfoBean employeeInfoBean;
	private List<EmployeeInfoBean> employeeList;

	// Getters and Setters

	public String getEmployeeType() {
		return employeeType;
	}

	public void setEmployeeType(String employeeType) {
		this.employeeType = employeeType;
	}

	public EmployeeInfoBean getEmployeeInfoBean() {
		return employeeInfoBean;
	}

	public void setEmployeeInfoBean(EmployeeInfoBean employeeInfoBean) {
		this.employeeInfoBean = employeeInfoBean;
	}

	public List<EmployeeInfoBean> getEmployeeList() {
		return employeeList;
	}

	public void setEmployeeList(List<EmployeeInfoBean> employeeList) {
		this.employeeList = employeeList;
	}

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
