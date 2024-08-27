package com.naresh.Database.CustomException;

public class SlotsNotAvailable extends RuntimeException {
	
	
	public SlotsNotAvailable(String msg)
	{
		super(msg);
	}
	
	public SlotsNotAvailable(String msg,Throwable cause)
	{
		super(msg,cause);
	}

}
