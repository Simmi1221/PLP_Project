package com.example.hotelmanagementsystem.service;

public interface CustomValidationService {

	public boolean customEmailValidation(String email);
	public boolean customLocationValidation(String location);
	public boolean customRoomIdValidation(int roomId);

}
