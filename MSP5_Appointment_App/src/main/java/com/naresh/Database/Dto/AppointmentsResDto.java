package com.naresh.Database.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentsResDto {
	
private int appointmentId;
	
	private int patientId;
	
	private int doctorId;
	
	private LocalDate appointmentDate;
	
	private String startTime;
	
	private String endTime;
	
	private String status;

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

	public String getStartTime() {
		return startTime;
	}

	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}

	public String getEndTime() {
		return endTime;
	}

	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "AppointmentsResDto [appointmentId=" + appointmentId + ", patientId=" + patientId + ", doctorId="
				+ doctorId + ", appointmentDate=" + appointmentDate + ", startTime=" + startTime + ", endTime="
				+ endTime + ", status=" + status + "]";
	}

	public AppointmentsResDto(int appointmentId, int patientId, int doctorId, LocalDate appointmentDate,
			String startTime, String endTime, String status) {
		super();
		this.appointmentId = appointmentId;
		this.patientId = patientId;
		this.doctorId = doctorId;
		this.appointmentDate = appointmentDate;
		this.startTime = startTime;
		this.endTime = endTime;
		this.status = status;
	}

	public AppointmentsResDto() {
		super();
	}
	
	
	
	
//	

}
