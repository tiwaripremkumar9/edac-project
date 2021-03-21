package com.app.custom_excs;

public class RestaurantHandlingException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public RestaurantHandlingException(String msg) {
		super(msg);
	}

}
