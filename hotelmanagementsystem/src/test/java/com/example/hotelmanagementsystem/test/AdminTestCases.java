package com.example.hotelmanagementsystem.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.hotelmanagementsystem.beans.HotelInfoBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;
import com.example.hotelmanagementsystem.dao.AdminDaoImpl;

@SpringBootTest
public class AdminTestCases {
	
	@Autowired
	private AdminDaoImpl adminDaoImpl;

	@Test
	public void testAddHotel() {
		HotelInfoBean bean = new HotelInfoBean();
		bean.setHotelName("Neeta Palace");
		bean.setLocation("3rd cross road GandhiNagar,Mumbai");
		boolean valid = adminDaoImpl.addHotel(bean);
		assertEquals(true, valid);
	}
	
	@Test
	public void testAddRoom() {
		RoomInfoBean bean=new RoomInfoBean();
		bean.setHotelId(1);
		bean.setRoomId(109);
		bean.setRoomCapacity(2);
		bean.setRoomRent(985);
		bean.setRoomStatus("available");
		bean.setRoomType(" Non AC classic(2x)");
		boolean valid=adminDaoImpl.addRoom(bean);
		assertEquals(true, valid);
		
	}
	
	@Test
	public void testDeleteRoom() {
		boolean valid=adminDaoImpl.deleteRoom(109);
	    assertEquals(true,valid);
	} 
	
	@Test
	public void testDeleteHotel() {
		boolean valid=adminDaoImpl.deleteHotel(8);
	    assertEquals(true,valid);
	}
	
	@Test 
	public void testUpdateHotel() {
		HotelInfoBean bean=new HotelInfoBean();
		bean.setHotelId(8);
		bean.setHotelName("RamLila Palace");
		bean.setLocation("M.G.Road,Chatrapati Chowk, Nagpur");
		boolean valid=adminDaoImpl.updateHotelDetails(bean);
		assertEquals(true, valid);
	}
	
	@Test
	public void testUpdateRoom() {
		RoomInfoBean bean=new RoomInfoBean();
		bean.setRoomId(102);
		bean.setRoomRent(1235);
		boolean valid=adminDaoImpl.updateRoomDetails(bean);
		assertEquals(true, valid);
	}
	
	@Test
	public void testAddEmployee() {
		UserBean user=new UserBean();
		String name="Sonali Jain ";
		user.setUserName(name);
		user.setEmail("sonali@gmail.com");
		user.setNationality("Indian");
		user.setPhoneNo("9876543210");
		user.setAdharNo("7899034561234");
		user.setPassword("Sonali123");
		UserBean user1=adminDaoImpl.addEmployee(user);
		assertEquals(name, user1.getUserName());
	}
}
