package com.example.hotelmanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.ResponseBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserBean;
import com.example.hotelmanagementsystem.service.CustomValidationService;
import com.example.hotelmanagementsystem.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {

	int userId = 0;

	@Autowired(required = true)
	private UserService userService;
	
	@Autowired
	private CustomValidationService customValidationService;

	@PostMapping("/registerAsUser")
	public ResponseBean register(@RequestBody UserBean userBean) {
		String email = userBean.getEmail();
		boolean isValid = customValidationService.customEmailValidation(email);
		if (!isValid) {
			ResponseBean response = new ResponseBean();
			UserBean user = userService.register(userBean);
			if (user != null) {
				response.setStatusCode(222);
				response.setMessage("success");
				response.setDescription("Registered successfully...");
			} else {
				response.setStatusCode(444);
				response.setMessage("failed");
				response.setDescription("Unable to register,Please try again!!!");
			}
			return response;

		} else {
			ResponseBean response = new ResponseBean();
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Entered email id already  exist!!!");
			return response;
		}

	}

	@PostMapping("/login")
	public ResponseBean login(@RequestBody UserBean userBean) {
		String email = userBean.getEmail();
		String password = userBean.getPassword();
		ResponseBean response = new ResponseBean();
		boolean isValid = customValidationService.customEmailValidation(email);
		if (isValid) {
		UserBean user = userService.login(email, password);
		if (user != null) {
			userId = user.getUserId();
			String userType = user.getUserType();
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Login successfully...");
			response.setUserType(userType);
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to login,Please register first!!!");
		}
	} else {
		response.setStatusCode(444);
		response.setMessage("failed");
		response.setDescription("Entered email id does not exist");
	}
		return response;
	}

	@PostMapping("/booking")
	public ResponseBean booking(@RequestBody BookingInfoBean bookingInfoBean) {
		ResponseBean response = new ResponseBean();
		boolean isBooked = userService.bookingRoom(bookingInfoBean, userId);
		if (isBooked) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Room booked successfully...");
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to book the room!!!");
		}
		return response;
	}

	@GetMapping("/getRoomDetails/{hotelId}")
	public ResponseBean getRoomDetails(@PathVariable int hotelId) {
		ResponseBean response=new ResponseBean();
		List<RoomInfoBean> roomList=userService.seeRoomDetails(hotelId);
		if(roomList!=null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Room details found...");
			response.setRoomList(roomList);
		}else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the details of room!!!");
		}
		
		return response;
	}
	@GetMapping("/getUserProfile")
	public ResponseBean getUserProfile() {

		UserBean userBean = userService.getUserProfile(userId);
		ResponseBean response = new ResponseBean();

		if (userBean != null) {
			response.setStatusCode(222);
			response.setMessage("SUCCESS");
			response.setDescription("USER FOUND");
			response.setUserBean(userBean);

		} else {
			response.setStatusCode(444);
			response.setMessage("FALIURE");
			response.setDescription("UNABLE TO FETCH DATA");
		}
		return response;
	}
	
	@PutMapping("/updateProfile")
	public ResponseBean updateRoomlDetails(@RequestBody UserBean userBean) {
		ResponseBean response=new ResponseBean();
		boolean isUpdated=userService.updateProfile(userId ,userBean);
		if(isUpdated) {
			response.setStatusCode(222);
			response.setMessage("succcess");
			response.setDescription("user details updated successfully...");
		}else {
			response.setStatusCode(444);
			response.setMessage("fail");
			response.setDescription("Unable to update the details of user!!!");
		}
		
		return response;
	}

}
