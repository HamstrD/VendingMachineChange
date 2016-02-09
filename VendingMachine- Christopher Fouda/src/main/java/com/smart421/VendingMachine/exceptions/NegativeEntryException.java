package com.smart421.VendingMachine.exceptions;

public class NegativeEntryException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public NegativeEntryException(){
		super();
	}
	
	public NegativeEntryException(String message){
		super(message);		
	}
	
	public NegativeEntryException(String message, Throwable cause){
		super(message,cause);		
	}
	
	public NegativeEntryException(Throwable cause){
		super(cause);		
	}
	

}
