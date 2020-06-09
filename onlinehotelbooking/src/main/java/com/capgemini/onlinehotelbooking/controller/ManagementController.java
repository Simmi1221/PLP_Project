package com.capgemini.onlinehotelbooking.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.capgemini.onlinehotelbooking.beans.BookingInfoBean;
import com.capgemini.onlinehotelbooking.beans.ResponseBean;
import com.capgemini.onlinehotelbooking.beans.UserBean;
import com.capgemini.onlinehotelbooking.service.CustomValidationService;
import com.capgemini.onlinehotelbooking.service.ManagementService;

@RestController
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class ManagementController {

	@Autowired(required = true)
	private ManagementService managementService;

	@Autowired
	private CustomValidationService customValidationService;

	@PostMapping("/addAdmin")
	public ResponseBean addadmin(@RequestBody UserBean userBean) {
		ResponseBean response = new ResponseBean();
		String email = userBean.getEmail();
	   boolean isValid = customValidationService.customEmailValidation(email);
	   if(!isValid) {
			UserBean user = managementService.addAdmin(userBean);
			if (user != null) {
				response.setStatusCode(222);
				response.setMessage("success");
				response.setDescription("Registered successfully...");
			} else {
				response.setStatusCode(444);
				response.setMessage("failed");
				response.setDescription("Unable to register,Please try again!!!");
			}
	   } else {
		   response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Entered email id is already exist");
	   }
		return response;
	}

	@GetMapping("/getCustomerDetails")
	public ResponseBean getCustomerDetails() {
		ResponseBean response = new ResponseBean();
		List<UserBean> customerList = managementService.viewCustomerDetails();
		if (customerList != null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Customer details found...");
			response.setUserList(customerList);
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the details of customer!!!");
		}

		return response;
	}

	@GetMapping("/getBillDetails")
	public ResponseBean getBillDetails() {
		ResponseBean response = new ResponseBean();
		List<BookingInfoBean> billList = managementService.viewBillDetails();
		if (billList != null) {
			response.setStatusCode(222);
			response.setMessage("success");
			response.setDescription("Bill details found...");
			response.setBookingList(billList);
		} else {
			response.setStatusCode(444);
			response.setMessage("failed");
			response.setDescription("Unable to found the bill details!!!");
		}

		return response;
	}

}
