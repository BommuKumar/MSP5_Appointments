package com.naresh.Database.Dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class AppointmentDto {
	
	
   private int appointmentId;
	
	private int patientId;
	
	private int doctorId;
	
	private LocalDate appointmentDate;
	
	private LocalTime startTime;
	
	private LocalTime endTime;
	
	private String status;
//	
//	private LocalDate createdAt;
//	
//	private LocalDate updatedAt;

	public int getAppointmentId() {
		return appointmentId;
	}

	public void setAppointmentId(int appointmentId) {
		this.appointmentId = appointmentId;
	}

	public int getPatientId() {
		return patientId;
	}

	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}

	public int getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(int doctorId) {
		this.doctorId = doctorId;
	}

	public LocalDate getAppointmentDate() {
		return appointmentDate;
	}

	public void setAppointmentDate(LocalDate appointmentDate) {
		this.appointmentDate = appointmentDate;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	 



	 
 

	@Override
	public String toString() {
		return "AppointmentDto [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId=" + doctorId
				+ ", appointmentDate=" + appointmentDate + ", startTime=" + startTime + ", endTime=" + endTime
				+ ", status=" + status + "]";
	}

	public AppointmentDto(int appointmentId, int patientId, int doctorId, LocalDate appointmentDate,
			LocalTime startTime, LocalTime endTime, String status) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public LocalTime getEndTime() {
		return endTime;
	}

	public void setEndTime(LocalTime endTime) {
		this.endTime = endTime;
	}

	public AppointmentDto() {
		super();
	}

}
