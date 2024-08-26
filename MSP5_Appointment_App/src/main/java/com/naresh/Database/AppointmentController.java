package com.naresh.Database;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Dto.AppointmentDto;
import com.naresh.Database.Service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
     AppointmentService appointmentService;
	
	@GetMapping("view/available/slots/{doctorId}")
	public ResponseEntity<List<LocalDate>> viewAvailableSlots(@PathVariable("doctorId") int doctorId) {
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.viewAvailableDays(doctorId));
	}
	
	@PostMapping("book/appointment")
	public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDto appointmentDto) {
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.bookAppointment(appointmentDto));
	}
	

}
