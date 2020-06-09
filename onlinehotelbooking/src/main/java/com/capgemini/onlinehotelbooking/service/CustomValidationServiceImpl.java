package com.capgemini.onlinehotelbooking.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.capgemini.onlinehotelbooking.validation.CustomValidation;

@Repository
public class CustomValidationServiceImpl implements CustomValidationService{


	@Autowired
	private CustomValidation dao;
	
	@Override
	public boolean customEmailValidation(String email) {
		return dao.customEmailValidation(email); 
	}

	@Override
	public boolean customLocationValidation(String location) {
		return dao.customLocationValidation(location);
	}

	@Override
	public boolean customRoomIdValidation(int roomId) {
		return dao.customRoomIdValidation(roomId);
	}

}
