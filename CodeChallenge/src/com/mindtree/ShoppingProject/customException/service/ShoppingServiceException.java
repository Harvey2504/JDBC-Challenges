package com.mindtree.ShoppingProject.customException.service;

public class ShoppingServiceException extends Exception {

	public ShoppingServiceException() {

	}

	public ShoppingServiceException(String arg0) {
		super(arg0);
	}

	public ShoppingServiceException(Throwable arg0) {
		super(arg0);
	}

	public ShoppingServiceException(String arg0, Throwable arg1) {
		super(arg0, arg1);
	}

}
