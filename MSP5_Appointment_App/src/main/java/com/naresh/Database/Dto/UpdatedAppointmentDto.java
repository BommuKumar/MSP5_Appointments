package com.naresh.Database.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class UpdatedAppointmentDto {
	
	
	private LocalDate appointmentDate;
	
	private LocalTime startTime;

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	@Override
	public String toString() {
		return "UpdatedAppointmentDto [appointmentDate=" + appointmentDate + ", startTime=" + startTime + "]";
	}

	public UpdatedAppointmentDto(LocalDate appointmentDate, LocalTime startTime) {
		super();
		this.appointmentDate = appointmentDate;
		this.startTime = startTime;
	}

	public UpdatedAppointmentDto() {
		super();
	}
	
	

}
