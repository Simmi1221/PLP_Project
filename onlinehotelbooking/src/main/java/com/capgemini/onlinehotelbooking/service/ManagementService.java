package com.capgemini.onlinehotelbooking.service;

import java.util.List;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;

public interface ManagementService {

	public UserBean addAdmin(UserBean bean);

	public List<RoomInfoBean> allotment();

	public List<UserBean> viewCustomerDetails();

	public List<BookingInfoBean> viewBillDetails();
}
