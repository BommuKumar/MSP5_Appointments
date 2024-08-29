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
  
  
    public Appointment findByAppointmentIdAndPatientId(int appointmentId,int patientId);
    
    public List<Appointment> findByDoctorIdAndStatus(int doctorId,String status);

   
    @Query(value="SELECT a.* FROM Appointment a WHERE a.patient_Id = :patientId " +
            "AND (:doctorId is null or a.doctor_Id=:doctorId)"+
    		"AND (:status is null or a.status=:status)"+
            "AND(:appointmentDate is null or a.appointment_Date=to_date(:appointmentDate,'yyyy-mm-dd'))",nativeQuery=true)
   public List<Appointment>  filterPAppointment(@Param("patientId")int patinetId,@Param("doctorId")Integer doctorId,@Param("appointmentDate")String appointmentDate,@Param("status")String status);


    @Query(value="SELECT a.* FROM Appointment a WHERE a.doctor_Id = :doctorId " +
            "AND (:patientId is null or a.patient_Id=:patientId)"+
    		"AND (:status is null or a.status=:status)"+
            "AND(:appointmentDate is null or a.appointment_Date=to_date(:appointmentDate,'yyyy-mm-dd'))",nativeQuery=true)
   public List<Appointment>  filterDAppointment(@Param("doctorId")int doctorId,@Param("patientId")Integer patinetId,@Param("appointmentDate")String appointmentDate,@Param("status")String status);



}
