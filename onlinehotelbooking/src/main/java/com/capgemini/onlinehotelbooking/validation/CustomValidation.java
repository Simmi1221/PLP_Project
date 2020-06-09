package com.capgemini.onlinehotelbooking.validation;

public interface CustomValidation {

	public boolean customEmailValidation(String email);

	public boolean customLocationValidation(String location);

	public boolean customRoomIdValidation(int roomId);

}
