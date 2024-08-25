package com.naresh.Database.Service;

import com.naresh.Database.Dto.AppointmentDto;
import com.naresh.Database.Dto.UserResponseDto;
import com.naresh.Database.Entity.Appointment;
import com.naresh.Database.Repository.AppointmentRepository;

import java.time.LocalDate;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AppointmentRepository  appointmentRepository;
	
	@Override
	public String bookAppointment(AppointmentDto appointmentDto) {
		 
		Appointment appointment=modelMapper.map(appointmentDto, Appointment.class);
		
		UserResponseDto  existedUser=(UserResponseDto) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		 
		if(existedUser.getRole().equalsIgnoreCase("patient"))
		{
			appointment.setPatientId(existedUser.getPatientId());
		}
		
		
		
		appointment.setStatus("booked");
		
		appointment.setCreatedAt(LocalDate.now());
		
		appointment.setUpdatedAt(LocalDate.now());
		
		Appointment bookedAppointment =appointmentRepository.save(appointment);
		
		
		
		
		return bookedAppointment!=null? "booked sucessfully ":"something went wrong please try again";
		
	}

}
