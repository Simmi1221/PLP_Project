package com.capgemini.onlinehotelbooking.junittestcases;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.onlinehotelbooking.beans.EmployeeInfoBean;
import com.capgemini.onlinehotelbooking.beans.HotelInfoBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;
import com.capgemini.onlinehotelbooking.dao.AdminDaoImpl;

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
		EmployeeInfoBean user=new EmployeeInfoBean();
		String name="Sonali Jain ";
		user.setEmployeeName(name);
		user.setEmail("sonali@gmail.com");
		user.setHotelName("The Pride");
		user.setPhoneNo("9876543210");
		user.setHotelId(1);
		user.setPassword("Sonali123");
		EmployeeInfoBean user1=adminDaoImpl.addEmployee(user);
		assertEquals(name, user1.getEmployeeName());
	}
}
