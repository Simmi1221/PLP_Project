package com.example.hotelmanagementsystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.example.hotelmanagementsystem.beans.UserBean;
import com.example.hotelmanagementsystem.dao.ManagementDaoImpl;

public class ManagementTestCases {
	
	@Autowired
	private ManagementDaoImpl managementDaoImpl;
	
	@BeforeEach
	public void createObject() {
		managementDaoImpl = new ManagementDaoImpl();
	}
	
	@Test
	public void testAddAdmin() {
		UserBean user=new UserBean();
		String name="Harshini Urmale";
		user.setUserName(name);
		user.setEmail("Urmale@gmail.com");
		user.setNationality("Indian");
		user.setPhoneNo("9876543210");
		user.setAdharNo("456767897654");
		user.setPassword("harshu123");
		UserBean user1=managementDaoImpl.addAdmin(user);
		assertEquals(name, user1.getUserName());
	}
	

	

}
