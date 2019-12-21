package com.example.hotelmanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.ResponseBean;
import com.example.hotelmanagementsystem.beans.UserBean;
import com.example.hotelmanagementsystem.service.UserService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class UserController {
	
	int userId=0;
	
	@Autowired(required = true)
	private UserService userService;
	
	@PostMapping("/registerAsUser")
	public ResponseBean register(@RequestBody UserBean userBean) {
		ResponseBean response=new ResponseBean();
		UserBean user=userService.register(userBean);
		if (user!=null) {
            response.setStatusCode(222);
            response.setMessage("success");
            response.setDescription("Registered successfully...");
		} else {
			response.setStatusCode(444);
            response.setMessage("failed");
            response.setDescription("Unable to register,Please try again!!!");
		}
		return response;
	}
	
	@PostMapping("/login")
	public ResponseBean login(@RequestBody UserBean userBean) {
		String email=userBean.getEmail();
		String password=userBean.getPassword();
		ResponseBean response=new ResponseBean();
		UserBean user=userService.login(email, password);
		if (user!=null) {
            response.setStatusCode(222);
            response.setMessage("success");
            response.setDescription("Login successfully...");
		} else {
			response.setStatusCode(444);
            response.setMessage("failed");
            response.setDescription("Unable to login,Please register first!!!");
		}
		return response;
	}
	
	@PostMapping("/booking")
	public ResponseBean booking(@RequestBody BookingInfoBean bookingInfoBean) {
		ResponseBean response=new ResponseBean();
		boolean isBooked=userService.bookingRoom(bookingInfoBean, userId);
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

}
