package com.naresh.Database.Service;

import com.naresh.Database.Dto.AppointmentDto;
import com.naresh.Database.Dto.UserResponseDto;
import com.naresh.Database.Entity.Appointment;
import com.naresh.Database.Repository.AppointmentRepository;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

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

	@Override
	public List<LocalDate> viewAvailableDays(int doctorId) {


		   List<Timestamp> allBookedDayss=appointmentRepository.findAllBookedDates(doctorId);
		
		   List<LocalDate> allBookedDays=allBookedDayss.stream().map(ts->ts.toLocalDateTime().toLocalDate()).collect(Collectors.toList());
		   
		   
		        LocalDate today=LocalDate.now();
		
		        List<LocalDate> allDates=today.datesUntil(today.plusWeeks(4)).filter(date->date.getDayOfWeek()!=DayOfWeek.SATURDAY&&date.getDayOfWeek()!=DayOfWeek.SUNDAY).collect(Collectors.toList());
		
		
		
		   
		
		       allDates.removeAll(allBookedDays);
		
		
		
		return allDates;
	}

}
