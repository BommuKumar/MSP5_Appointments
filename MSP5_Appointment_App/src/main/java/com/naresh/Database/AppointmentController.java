package com.naresh.Database;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.CustomException.SlotAlreadyBooked;
import com.naresh.Database.CustomException.SlotsNotAvailable;
import com.naresh.Database.Dto.AppointmentDto;
import com.naresh.Database.Dto.UpdatedAppointmentDto;
import com.naresh.Database.Service.AppointmentService;
import com.naresh.Database.Service.AppointmentServiceImpl;

@RestController
public class AppointmentController {
	
	@Autowired
     AppointmentService appointmentService;
	
    private static final Logger log = LoggerFactory.getLogger(AppointmentController.class);

	
	@GetMapping("view/available/slots/{doctorId}")
	public ResponseEntity<List<LocalDate>> viewAvailableSlots(@PathVariable("doctorId") int doctorId) {
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.viewAvailableDays(doctorId));
	}
	
	@PostMapping("book/appointment")
	public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDto appointmentDto) {
		
		
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.bookAppointment(appointmentDto));
	}
	@ExceptionHandler(SlotAlreadyBooked.class)
      public ResponseEntity<String> SlotAlreadyBookedHandler(SlotAlreadyBooked ex) {
		
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(ex.getLocalizedMessage());
	}
	// slots
	
	
	
	@GetMapping("get/available/slots/{doctorId}")
	public ResponseEntity<List<String>> getAvailableSlots(@PathVariable("doctorId") int doctorId,@RequestParam("appointmentDate") LocalDate appointmentDate) {
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.getAvailableSlots(doctorId, appointmentDate));
	}
	
	
	@PostMapping("update/appointment/{appointmentId}")
	
	public ResponseEntity<String> updateAppointment(@PathVariable("appointmentId") int appointmentId,@RequestBody UpdatedAppointmentDto updatedAppointmentDto) {
		 
		try
		{
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.updateAppointment(appointmentId, updatedAppointmentDto));
	   }
		catch(SlotAlreadyBooked ex)
		{
			log.debug("SlotNotAvailable exception occured");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
        }
		catch(SlotsNotAvailable ex)
		{
			log.debug("SlotsNotAvailable exception occured");
			
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getLocalizedMessage());
        }
		
		
	}
	
	
	

}
