package com.naresh.Database.Service;
import org.slf4j.Logger;
import com.naresh.Database.CustomException.*;

import com.naresh.Database.Dto.AppointmentDto;
import com.naresh.Database.Dto.UpdatedAppointmentDto;
import com.naresh.Database.Dto.UserResponseDto;
import com.naresh.Database.Entity.Appointment;
import com.naresh.Database.Repository.AppointmentRepository;

import lombok.extern.log4j.Log4j2;
import lombok.extern.slf4j.Slf4j;

import java.sql.Timestamp;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.apache.juli.logging.Log;
import org.modelmapper.ModelMapper;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Log4j2
@Slf4j
public class AppointmentServiceImpl implements AppointmentService{

	@Autowired
	ModelMapper modelMapper;
	
	@Autowired
	AppointmentRepository  appointmentRepository;
	
    private static final Logger log = LoggerFactory.getLogger(AppointmentServiceImpl.class);
	
	@Override
	public String bookAppointment(AppointmentDto appointmentDto) {
		 
		Appointment appointment=modelMapper.map(appointmentDto, Appointment.class);
		
 
 		
		List<String> availableSlots=getAvailableSlots(appointmentDto.getDoctorId(), appointmentDto.getAppointmentDate());
 		 
		 for(String res:availableSlots)
		 {
			 log.info(res);
		 }
		
		  if(availableSlots.isEmpty())
		 	{
	 		 	  throw new SlotsNotAvailable("slots not available for this day "+appointmentDto.getAppointmentDate());	
		 	} 
		  else
		  {
			 if(availableSlots.contains(appointmentDto.getStartTime().format(DateTimeFormatter.ofPattern("hh:mm a"))))
			 {
				 
					LocalDateTime startTime = LocalDateTime.of(appointmentDto.getAppointmentDate(),
							appointmentDto.getStartTime());

					appointment.setStartTime(startTime);
					appointment.setEndTime(startTime.plusHours(1));

					UserResponseDto existedUser = (UserResponseDto) SecurityContextHolder.getContext()
							.getAuthentication().getPrincipal();

					if (existedUser.getRole().equalsIgnoreCase("patient")) {
						appointment.setPatientId(existedUser.getPatientId());
					}

					appointment.setStatus("booked");

					appointment.setCreatedAt(LocalDate.now());

					appointment.setUpdatedAt(LocalDate.now());

					Appointment bookedAppointment = appointmentRepository.save(appointment);

					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("hh:mm a");

					return bookedAppointment != null
							? "your Apppointment booked sucessfully form "
									+ bookedAppointment.getStartTime().format(formatter) + "to"
									+ bookedAppointment.getEndTime().format(formatter)
							: "something went wrong please try again";
	       }
			else
	 	    {
	 	    throw new SlotAlreadyBooked("SlotAlreadyBooked for this day " +appointmentDto.getAppointmentDate()+"at"+appointmentDto.getStartTime());
	 	     }
	}}

	@Override
	public List<LocalDate> viewAvailableDays(int doctorId) {
		
		
 
		   List<Timestamp> allBookedDayss=appointmentRepository.findAllBookedDates(doctorId);
		
		   List<LocalDate> allBookedDays=allBookedDayss.stream().map(ts->ts.toLocalDateTime().toLocalDate()).collect(Collectors.toList());
		   
		   
		        LocalDate today=LocalDate.now();
		
		        List<LocalDate> allDates=today.datesUntil(today.plusWeeks(4)).filter(date->date.getDayOfWeek()!=DayOfWeek.SATURDAY&&date.getDayOfWeek()!=DayOfWeek.SUNDAY).collect(Collectors.toList());
		
		
		
		   
		
		       allDates.removeAll(allBookedDays);
		
		
		
		return allDates;
	}

	
	@Override
	public List<String> getAvailableSlots(int doctorId, LocalDate appointmentDate) {
		
		List<LocalTime> fixedslots=	getFixedSlots();
		
	     log.info(""+fixedslots.size());
		
		
		List<LocalTime> bookedslots=getBookedslots(doctorId,appointmentDate);
		
       log.info(""+bookedslots.size());
		
		
           fixedslots.removeAll(bookedslots);
           
   	    	DateTimeFormatter formatter =DateTimeFormatter.ofPattern("hh:mm a");
            
   	    	List<String> res= fixedslots.stream().map(slot->slot.format(formatter)).collect(Collectors.toList());
           
           return res;
	}

	
	
	
	
	private List<LocalTime> getFixedSlots()
	{
		List<LocalTime> slots= new ArrayList();
		
		LocalTime start=LocalTime.of(10,0);
		
		LocalTime end=LocalTime.of(16,0);

		 while(start.isBefore(end))
		 {
			 slots.add(start);
			 
			 if(!start.equals(LocalTime.of(13, 0)))
			    {
			      start = start.plusHours(1);
		        } else {
		            start = start.plusHours(1); // Ensure this line always executes.
		        }			 
		 }
		return slots;
		
	}
	private List<LocalTime> getBookedslots(int doctorId,LocalDate appointmentDate)
	{
		
		List<Appointment> appointments= appointmentRepository.findByDoctorIdAndAppointmentDate(doctorId, appointmentDate);
		
		
		return appointments.stream().map(appoint->
		{
			return appoint.getStartTime().toLocalTime();
		}).collect(Collectors.toList());
		 
	}

	@Override
	public String updateAppointment(int appointmentId,UpdatedAppointmentDto updatedAppointmentDto) {


		Appointment appointment =appointmentRepository.findById(appointmentId).orElseThrow(()->new AppointmentNotFound("Appointment not found with this id"+appointmentId));		
		
		List<String> avilableSlots= new ArrayList();

		if(updatedAppointmentDto.getAppointmentDate()!=null)	
		{
			avilableSlots=getAvailableSlots(appointment.getDoctorId(), updatedAppointmentDto.getAppointmentDate());
			
 		 	if(avilableSlots.isEmpty())
 		 	{
 	 		 	  throw new SlotsNotAvailable("slots not available for this day "+updatedAppointmentDto.getAppointmentDate());	
 		 	} 
 		 	 
 		}
		
		log.info("Available slots are"+avilableSlots);
		
		if(updatedAppointmentDto.getStartTime()!=null)
		{	
			DateTimeFormatter timePattern=  DateTimeFormatter.ofPattern("hh:mm a");

			
 	       String startingtTime=updatedAppointmentDto.getStartTime().format(timePattern);
 	       
 	      if(avilableSlots.contains(startingtTime))
 	      {
 		
 	       LocalDateTime start=LocalDateTime.of(updatedAppointmentDto.getAppointmentDate(), updatedAppointmentDto.getStartTime());
		 	
 	       appointment.setAppointmentDate(updatedAppointmentDto.getAppointmentDate());

 	       appointment.setStartTime(start);
 	       
 	      appointment.setEndTime(start.plusHours(1));
		
 	      appointment.setUpdatedAt(LocalDate.now());
 	      
 			Appointment  updatedAppointment=appointmentRepository.save(appointment);

 			return "Appointment updated sucessfully.your Revised slot is scheduled on "+updatedAppointment.getAppointmentDate()+"at"+updatedAppointment.getStartTime().format(timePattern)+"to"+updatedAppointment.getEndTime().format(timePattern);

	      }
 	      else
 	      {
 	    	 throw new SlotAlreadyBooked("SlotAlreadyBooked for this day " +updatedAppointmentDto.getAppointmentDate()+"at"+updatedAppointmentDto.getStartTime());
 	      }

 	 	}
		return null;
	
}}
