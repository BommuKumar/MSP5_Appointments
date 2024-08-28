package com.naresh.Database.CustomException;

public class AppointmentsNotFound extends RuntimeException {
	
	
	public AppointmentsNotFound(String msg)
	{
		super(msg);
	}
	
	public AppointmentsNotFound(String msg,Throwable cause)
	{
		super(msg,cause);
	}
}
