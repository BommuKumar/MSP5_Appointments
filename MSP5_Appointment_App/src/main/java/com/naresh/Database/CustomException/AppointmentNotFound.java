package com.naresh.Database.CustomException;

public class AppointmentNotFound extends RuntimeException {
	
	
	public AppointmentNotFound(String msg)
	{
		super(msg);
	}
	
	public AppointmentNotFound(String msg,Throwable cause)
	{
		super(msg,cause);
	}


}
