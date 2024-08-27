package com.naresh.Database.Repository;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.naresh.Database.Entity.Appointment;

@Repository
public interface AppointmentRepository extends JpaRepository<Appointment, Integer> {

	
	@Query(value="SELECT  a.appointment_Date FROM Appointment a WHERE a.doctor_Id =:doctorId AND a.status = 'booked'",nativeQuery = true)
   public List<Timestamp> findAllBookedDates(@Param("doctorId") int doctorId);
	
	
	
    public List<Appointment> findByDoctorIdAndAppointmentDate(int doctorId,LocalDate appointmentDate);
  
  
}
