package com.naresh.Database.Dto;

import java.time.LocalDate;
import java.time.LocalTime;

public class AppointmentResponseDto {

	
	   private int appointmentId;
		
		private int patientId;
		
		//private int doctorId;
		
		private LocalDate appointmentDate;
		
		private String startTime;
		
		private String endTime;

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

		public AppointmentResponseDto() {
			super();
		}

		@Override
		public String toString() {
			return "AppointmentResponseDto [appointmentId=" + appointmentId + ", patientId=" + patientId
					+ ", appointmentDate=" + appointmentDate + ", startTime=" + startTime + ", endTime=" + endTime
					+ "]";
		}

		public AppointmentResponseDto(int appointmentId, int patientId, LocalDate appointmentDate, String startTime,
				String endTime) {
			super();
			this.appointmentId = appointmentId;
			this.patientId = patientId;
			this.appointmentDate = appointmentDate;
			this.startTime = startTime;
			this.endTime = endTime;
		}

		 
 
}
