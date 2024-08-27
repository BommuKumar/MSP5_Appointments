package com.naresh.Database.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import com.naresh.Database.Dto.AppointmentDto;
import com.naresh.Database.Dto.UpdatedAppointmentDto;

public interface AppointmentService {
	
	public String bookAppointment(AppointmentDto appointmentDto );
	
	
	public List<LocalDate> viewAvailableDays(int doctorId);


	public List<String> getAvailableSlots(int doctorId,LocalDate appointmentDate);

	
	public String updateAppointment(int appointmentId,UpdatedAppointmentDto updatedAppointmentDto);
	
	
}
