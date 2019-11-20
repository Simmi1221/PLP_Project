package com.example.hotelmanagementsystem.service;

import java.util.List;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;

public interface ManagementService {

	public UserBean addAdmin(UserBean bean);

	public List<RoomInfoBean> allotment();

	public List<UserBean> viewCustomerDetails();

	public List<BookingInfoBean> viewBillDetails();
}
