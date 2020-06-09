package com.capgemini.onlinehotelbooking.junittestcases;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;
import com.capgemini.onlinehotelbooking.dao.UserDaoImpl;
import com.capgemini.onlinehotelbooking.exception.HotelCustomException;

@SpringBootTest
public class UserTestCases {

	@Autowired
	private UserDaoImpl userDaoImpl;

	@Test
	public void testAdminLoginAsUser() {
		String email = "simmimulani1221@gmail.com";
		String password = "Simmi1221";
		UserBean user = userDaoImpl.login(email, password);
		String name = "Simran Vajuddin Mulani";
		assertEquals(name, user.getUserName());
	}

	@Test
	public void testRegister() {
		UserBean user = new UserBean();
		String name = "Dhanashri Bhong";
		user.setUserName(name);
		user.setEmail("dhanu@gmail.com");
		user.setNationality("Indian");
		user.setPhoneNo("1234567890");
		user.setAdharNo("123467897654");
		user.setPassword("dhanu123");
		UserBean user1 = userDaoImpl.register(user);
		assertEquals(name, user1.getUserName());
	}

	@Test
	public void testBookingRoom() {

		try {
			BookingInfoBean bean = new BookingInfoBean();
			bean.setAmount(1225);
			String startDate = "2019/12/23";
			String endDate = "2019/12/24";
			SimpleDateFormat format = new SimpleDateFormat("yyyy/mm/dd");
			Date date = format.parse(startDate);
			bean.setCheckinDate(date);
			Date date1 = format.parse(endDate);
			bean.setCheckoutDate(date1);
			bean.setModeOfPayment("Cash On delivery");
			bean.setPaymentStatus("Not paid");
			bean.setRoomId(102);
			bean.setHotelId(1);
			int userId = 2;
			boolean valid = userDaoImpl.bookingRoom(bean, userId);
			assertEquals(true, valid);
		} catch (ParseException e) {
			throw new HotelCustomException("Something went wrong...room cannot be add");
		}

	}

	@Test
	public void testGetUserProfile() {
		int userId = 2;
		String userName = "Safura Vajuddin Mulani";
		UserBean user = userDaoImpl.getUserProfile(userId);
		assertEquals(userName, user.getUserName());

	}

	@Test
	public void testUpdateProfile() {
		UserBean user = new UserBean();
		user.setAdharNo("678976541234");
		boolean valid = userDaoImpl.updateProfile(2, user);
		assertEquals(true, valid);
	}

}
