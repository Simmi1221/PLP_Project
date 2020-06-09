package com.capgemini.onlinehotelbooking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;
import com.capgemini.onlinehotelbooking.dao.ManagementDao;

@Service
public class ManagementServiceImpl implements ManagementService {

	@Autowired
	private ManagementDao dao;

	@Override
	public UserBean addAdmin(UserBean bean) {
		return dao.addAdmin(bean);
	}

	@Override
	public List<RoomInfoBean> allotment() {
		return dao.allotment();
	}

	@Override
	public List<UserBean> viewCustomerDetails() {
		return dao.viewCustomerDetails();
	}

	@Override
	public List<BookingInfoBean> viewBillDetails() {
		return dao.viewBillDetails();
	}

}
