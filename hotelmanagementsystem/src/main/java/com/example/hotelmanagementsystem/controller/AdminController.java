package com.example.hotelmanagementsystem.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.hotelmanagementsystem.beans.BookingInfoBean;
import com.example.hotelmanagementsystem.beans.HotelInfoBean;
import com.example.hotelmanagementsystem.beans.ResponseBean;
import com.example.hotelmanagementsystem.beans.RoomInfoBean;
import com.example.hotelmanagementsystem.beans.UserDetailsBean;
import com.example.hotelmanagementsystem.service.AdminService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

	@Autowired(required = true)
	private AdminService adminService;

	@PostMapping("/addHotelDetails")
	public ResponseBean addHoteldetails(@RequestBody HotelInfoBean hotelInfoBean) {
		ResponseBean response = new ResponseBean();
		boolean isAdded = adminService.addHotel(hotelInfoBean);
		if (isAdded) {
            response.setStatusCode(222);
            response.setMessage("success");
            response.setDescription("Hotel Details added successfully...");
		} else {
			response.setStatusCode(444);
            response.setMessage("failed");
            response.setDescription("Hotel Details unable to add!!!");
		}
		return response;
	}
	
	@PutMapping("/updateHotelDetails")
	public ResponseBean updateHotelDetails(@RequestBody HotelInfoBean hotelInfoBean) {
		ResponseBean response=new ResponseBean();
		boolean isUpdated=adminService.updateHotelDetails(hotelInfoBean);
		if(isUpdated) {
			response.setStatusCode(222);
			response.setMessage("succcess");
			response.setDescription("Hotel details updated successfully...");
		}else {
			response.setStatusCode(444);
			response.setMessage("success");
			response.setDescription("Unable to update the details of hotel!!!");
		}
		
		return response;
	}
	
	@DeleteMapping("deleteHotelDetails/{hotelId}")
	public ResponseBean deleteHotelDetails(@PathVariable int hotelId) {
		ResponseBean response=new ResponseBean();
		boolean isDeleted=adminService.deleteHotel(hotelId);
		if(isDeleted) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Hotel details deleted successfully...");
		}else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to delete the details of hotel!!!");
		}
		
		return response;
	}
	
	@GetMapping("/getHotelDetails")
	public ResponseBean getHotelDetails() {
		ResponseBean response=new ResponseBean();
		List<HotelInfoBean> hotelList=adminService.seeHotelDetails();
		if(hotelList!=null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Hotel details found...");
			response.setHotelList(hotelList);
		}else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the details of hotel!!!");
		}
		
		return response;
	}
	
	@PostMapping("/addRoomDetails")
	public ResponseBean addRoomDetails(@RequestBody RoomInfoBean roomInfoBean) {
		ResponseBean response = new ResponseBean();
		boolean isAdded = adminService.addRoom(roomInfoBean);
		if (isAdded) {
            response.setStatusCode(222);
            response.setMessage("success");
            response.setDescription("Room Details added successfully...");
		} else {
			response.setStatusCode(444);
            response.setMessage("failed");
            response.setDescription("Room Details unable to add!!!");
		}
		return response;
	}
	
	@PutMapping("/updateRoomDetails")
	public ResponseBean updateRoomlDetails(@RequestBody RoomInfoBean roomInfoBean) {
		ResponseBean response=new ResponseBean();
		boolean isUpdated=adminService.updateRoomDetails(roomInfoBean);
		if(isUpdated) {
			response.setStatusCode(222);
			response.setMessage("succcess");
			response.setDescription("Room details updated successfully...");
		}else {
			response.setStatusCode(444);
			response.setMessage("success");
			response.setDescription("Unable to update the details of Room!!!");
		}
		
		return response;
	}
	
	@DeleteMapping("deleteRoomDetails/{roomId}")
	public ResponseBean deleteRoomDetails(@PathVariable int roomId) {
		ResponseBean response=new ResponseBean();
		boolean isDeleted=adminService.deleteRoom(roomId);
		if(isDeleted) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Room details deleted successfully...");
		}else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to delete the details of Room!!!");
		}
		
		return response;
	}
	
	@GetMapping("/bookingListOfSpecificHotel/{hotelId}")
	public ResponseBean bookingListOfSpecificHotel(@PathVariable int hotelId) {
		ResponseBean response=new ResponseBean();
		List<BookingInfoBean> bookingList=adminService.bookingListOfSpecificHotel(hotelId);
		if(bookingList!=null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Booking list of specific hotel found...");
			response.setBoookingList(bookingList);;
		}else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the booking list of specific hotel!!!");
		}
		
		return response;
	}
	
	@GetMapping("/guestListOfSpecificHotel/{hotelId}")
	public ResponseBean guestListOfSpecificHotel(@PathVariable int hotelId) {
		ResponseBean response=new ResponseBean();
		List<UserDetailsBean> guestList=adminService.guestListOfSpecificHotel(hotelId);
		if(guestList!=null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Guest list of specific hotel is found...");
			response.setUserList(guestList);;
		}else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the guest list of specific hotel!!!");
		}
		
		return response;
	}
	
	@GetMapping("/bookingListOfSpecificDate")
	public ResponseBean bookingListOfSpecificDate(@RequestBody BookingInfoBean bookingInfoBean) {
		ResponseBean response=new ResponseBean();
		Date date=bookingInfoBean.getCheckinDate();
		List<BookingInfoBean> bookingList=adminService.bookingListOfSpecificDate(date);
		if(bookingList!=null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Booking list of specific date is found...");
			response.setBoookingList(bookingList);;
		}else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the booking list of specific date!!!");
		}
		
		return response;
	}
	
}
