package com.capgemini.onlinehotelbooking.controller;

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

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.EmployeeInfoBean;
import com.capgemini.onlinehotelbooking.beans.HotelInfoBean;
import com.capgemini.onlinehotelbooking.beans.ResponseBean;
import com.capgemini.onlinehotelbooking.beans.RoomInfoBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;
import com.capgemini.onlinehotelbooking.service.AdminService;
import com.capgemini.onlinehotelbooking.service.CustomValidationService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class AdminController {

	@Autowired(required = true)
	private AdminService adminService;

	@Autowired
	private CustomValidationService customValidationService;

	@PostMapping("/addHotelDetails")
	public ResponseBean addHoteldetails(@RequestBody HotelInfoBean hotelInfoBean) {
		ResponseBean response = new ResponseBean();
		String location = hotelInfoBean.getLocation();
		boolean isValid = customValidationService.customLocationValidation(location);
		if (!isValid) {
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
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Hotel location already exist");
		}
		return response;
	}

	@PutMapping("/updateHotelDetails")
	public ResponseBean updateHotelDetails(@RequestBody HotelInfoBean hotelInfoBean) {
		ResponseBean response = new ResponseBean();
		String location = hotelInfoBean.getLocation();
		boolean isValid = customValidationService.customLocationValidation(location);
		if (isValid) {
			boolean isUpdated = adminService.updateHotelDetails(hotelInfoBean);
			if (isUpdated) {
				response.setStatusCode(222);
				response.setMessage("succcess");
				response.setDescription("Hotel details updated successfully...");
			} else {
				response.setStatusCode(444);
				response.setMessage("fail");
				response.setDescription("Unable to update the details of hotel!!!");
			}
		} else {
			response.setStatusCode(444);
			response.setMessage("fail");
			response.setDescription("Hotel location already exist");
		}

		return response;
	}

	@DeleteMapping("deleteHotelDetails/{hotelId}")
	public ResponseBean deleteHotelDetails(@PathVariable int hotelId) {
		ResponseBean response = new ResponseBean();
		boolean isDeleted = adminService.deleteHotel(hotelId);
		if (isDeleted) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Hotel details deleted successfully...");
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to delete the details of hotel!!!");
		}

		return response;
	}

	@GetMapping("/getHotelDetails")
	public ResponseBean getHotelDetails() {
		ResponseBean response = new ResponseBean();
		List<HotelInfoBean> hotelList = adminService.seeHotelDetails();
		if (hotelList != null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Hotel details found...");
			response.setHotelList(hotelList);
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the details of hotel!!!");
		}

		return response;
	}

	@PostMapping("/addRoomDetails")
	public ResponseBean addRoomDetails(@RequestBody RoomInfoBean roomInfoBean) {
		ResponseBean response = new ResponseBean();
		int roomId = roomInfoBean.getRoomId();
		boolean isValid = customValidationService.customRoomIdValidation(roomId);
		if (!isValid) {
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
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Room Id alreadt exist");
		}

		return response;
	}

	@PutMapping("/updateRoomDetails")
	public ResponseBean updateRoomlDetails(@RequestBody RoomInfoBean roomInfoBean) {
		ResponseBean response = new ResponseBean();
		int roomId = roomInfoBean.getRoomId();
		boolean isValid = customValidationService.customRoomIdValidation(roomId);
		if (isValid) {
			boolean isUpdated = adminService.updateRoomDetails(roomInfoBean);
			if (isUpdated) {
				response.setStatusCode(222);
				response.setMessage("succcess");
				response.setDescription("Room details updated successfully...");
			} else {
				response.setStatusCode(444);
				response.setMessage("fail");
				response.setDescription("Unable to update the details of Room!!!");
			}
		} else {
			response.setStatusCode(444);
			response.setMessage("fail");
			response.setDescription("Entered room id is not  exist");
		}
		return response;
	}

	@DeleteMapping("deleteRoomDetails/{roomId}")
	public ResponseBean deleteRoomDetails(@PathVariable int roomId) {
		ResponseBean response = new ResponseBean();
		boolean isDeleted = adminService.deleteRoom(roomId);
		if (isDeleted) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Room details deleted successfully...");
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to delete the details of Room!!!");
		}

		return response;
	}

	@GetMapping("/getRoomDetails")
	public ResponseBean getRoomDetails() {
		ResponseBean response = new ResponseBean();
		List<RoomInfoBean> roomList = adminService.seeRoomDetails();
		if (roomList != null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Room details found...");
			response.setRoomList(roomList);
			;
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the details of room!!!");
		}

		return response;
	}

	@GetMapping("/bookingListOfSpecificHotel/{hotelId}")
	public ResponseBean bookingListOfSpecificHotel(@PathVariable int hotelId) {
		ResponseBean response = new ResponseBean();
		List<BookingInfoBean> bookingList = adminService.bookingListOfSpecificHotel(hotelId);
		if (bookingList != null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Booking list of specific hotel found...");
			response.setBoookingList(bookingList);
			;
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the booking list of specific hotel!!!");
		}

		return response;
	}

	@GetMapping("/guestListOfSpecificHotel/{hotelId}")
	public ResponseBean guestListOfSpecificHotel(@PathVariable int hotelId) {
		ResponseBean response = new ResponseBean();
		List<BookingInfoBean> guestList = adminService.guestListOfSpecificHotel(hotelId);
		if (guestList != null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Guest list of specific hotel is found...");
			response.setBookingList(guestList);
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the guest list of specific hotel!!!");
		}

		return response;
	}

	@GetMapping("/bookingListOfSpecificDate")
	public ResponseBean bookingListOfSpecificDate(@RequestBody BookingInfoBean bookingInfoBean) {
		ResponseBean response = new ResponseBean();
		Date date = bookingInfoBean.getCheckinDate();
		List<BookingInfoBean> bookingList = adminService.bookingListOfSpecificDate(date);
		if (bookingList != null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Booking list of specific date is found...");
			response.setBoookingList(bookingList);
			;
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the booking list of specific date!!!");
		}

		return response;
	}

	@PostMapping("/addEmployee")
	public ResponseBean register(@RequestBody EmployeeInfoBean employeeBean) {
		ResponseBean response = new ResponseBean();
		EmployeeInfoBean employee = adminService.addEmployee(employeeBean);
		if (employee != null) {
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

	@GetMapping("/searchHotelDetails")
	public ResponseBean searchHotelDetails(@RequestBody HotelInfoBean hotelInfoBean) {
		String location=hotelInfoBean.getLocation();
		ResponseBean response = new ResponseBean();
		List<HotelInfoBean> hotelList = adminService.searchHotel(location);
		if (hotelList != null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Hotel details found...");
			response.setHotelList(hotelList);
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the details of hotel!!!");
		}

		return response;
	}

}
