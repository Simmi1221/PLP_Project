package com.capgemini.onlinehotelbooking.exception;

@SuppressWarnings("serial")
public class HotelCustomException extends RuntimeException {
	String message;

	public HotelCustomException(String message) {
		super();
		this.message = message;
	}

//	@Override
//	public String getMessage() {
//		return message;
//	}

}
