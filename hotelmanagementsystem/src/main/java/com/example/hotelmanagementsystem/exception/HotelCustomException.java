package com.example.hotelmanagementsystem.exception;

public class HotelCustomException extends Exception {
	String message;

	public HotelCustomException(String message) {
		super();
		this.message = message;
	}

	@Override
	public String getMessage() {
		return message;
	}

}
