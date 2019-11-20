package com.example.hotelmanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;
import com.example.hotelmanagementsystem.dao.ManagementDao;

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
