package com.smart421.VendingMachine.exceptions;

public class InsufficentChangeException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public InsufficentChangeException(){
		super();
	}
	
	public InsufficentChangeException(String message){
		super(message);		
	}
	
	public InsufficentChangeException(String message, Throwable cause){
		super(message,cause);		
	}
	
	public InsufficentChangeException(Throwable cause){
		super(cause);		
	}
	

}
