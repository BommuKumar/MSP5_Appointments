package com.naresh.Database;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.naresh.Database.Dto.AppointmentDto;
import com.naresh.Database.Service.AppointmentService;

@RestController
public class AppointmentController {
	
	@Autowired
     AppointmentService appointmentService;
	
	@PostMapping("book/appointment")
	public ResponseEntity<String> bookAppointment(@RequestBody AppointmentDto appointmentDto) {
		 
		return ResponseEntity.status(HttpStatus.CREATED).body(appointmentService.bookAppointment(appointmentDto));
	}
	

}
