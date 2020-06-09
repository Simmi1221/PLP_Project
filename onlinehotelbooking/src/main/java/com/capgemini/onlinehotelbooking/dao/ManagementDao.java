package com.capgemini.onlinehotelbooking.dao;

import java.util.List;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;

public interface ManagementDao {

	public UserBean addAdmin(UserBean bean);

	public List<RoomInfoBean> allotment();

	public List<UserBean> viewCustomerDetails();

	public List<BookingInfoBean> viewBillDetails();

}
