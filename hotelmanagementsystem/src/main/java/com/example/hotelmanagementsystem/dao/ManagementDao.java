package com.example.hotelmanagementsystem.dao;

import java.util.List;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;

public interface ManagementDao {

	public UserBean addAdmin(UserBean bean);

	public List<RoomInfoBean> allotment();

	public List<UserBean> viewCustomerDetails();

	public List<BookingInfoBean> viewBillDetails();

}
