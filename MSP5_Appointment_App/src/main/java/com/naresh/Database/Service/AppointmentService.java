package com.naresh.Database.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.naresh.Database.Dto.AppointmentDto;
import com.naresh.Database.Dto.AppointmentResponseDto;
import com.naresh.Database.Dto.UpdatedAppointmentDto;

public interface AppointmentService {
	
	public String bookAppointment(AppointmentDto appointmentDto );
	
	
	public List<LocalDate> viewAvailableDays(int doctorId);


	public List<String> getAvailableSlots(int doctorId,LocalDate appointmentDate);

	
	public String RescheduleAppointment(int appointmentId,UpdatedAppointmentDto updatedAppointmentDto);
	
	
	public String cancelAppointment(int appointmentId);
	
	
	// . Doctor's Daily Schedule Overview
	
	public  List<AppointmentResponseDto> getAllAppointments();
	

	
	
	
}
