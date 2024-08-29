package com.naresh.Database.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Map;

import com.naresh.Database.Dto.AppointmentDto;
import com.naresh.Database.Dto.AppointmentResponseDto;
import com.naresh.Database.Dto.AppointmentsResDto;
import com.naresh.Database.Dto.UpdatedAppointmentDto;
import com.naresh.Database.Entity.Appointment;

public interface AppointmentService {
	
	public String bookAppointment(AppointmentDto appointmentDto );
	
	
	public List<LocalDate> viewAvailableDays(int doctorId);


	public List<String> getAvailableSlots(int doctorId,LocalDate appointmentDate);

	
	public String RescheduleAppointment(int appointmentId,UpdatedAppointmentDto updatedAppointmentDto);
	
	
	public String cancelAppointment(int appointmentId);
	
	
	// . Doctor's Daily Schedule Overview
	
	public  List<AppointmentResponseDto> getAllAppointments();
	

	//  patinets filters their appointmens
	
	
	public List<AppointmentsResDto>  filteredAppointment(Integer doctorId,String appointmentDate,String status);
	 
	 

	public List<AppointmentsResDto>  filteredDAppointment(Integer patientid,String appointmentDate,String status);
	 
}
