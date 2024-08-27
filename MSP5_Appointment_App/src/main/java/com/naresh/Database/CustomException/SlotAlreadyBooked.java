package com.naresh.Database.CustomException;

public class SlotAlreadyBooked  extends RuntimeException {
	
	
	public SlotAlreadyBooked(String msg)
	{
		super(msg);
	}
	
	public SlotAlreadyBooked(String msg,Throwable cause)
	{
		super(msg,cause);
	}

}
