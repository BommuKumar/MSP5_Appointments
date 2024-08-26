package com.naresh.Database.Service;

import java.time.LocalDate;
import java.util.List;

import com.naresh.Database.Dto.AppointmentDto;

public interface AppointmentService {
	
	public String bookAppointment(AppointmentDto appointmentDto );
	
	
	public List<LocalDate> viewAvailableDays(int doctorId);


}
