package com.naresh.Database.Dto;

import java.time.LocalDate;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;

import jakarta.persistence.Column;

public class UserResponseDto {
	
   private int userId;
	
	 
	private String name;
	
 
	private String pass;
	
	private String role;
	
	private Integer doctorId;
	
	private Integer  patientId;
	
	private LocalDate createdAt;
	
	private LocalDate  updatedAt;
	
	private List<String> authorities;

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getName() {
		return name;
	}
 

	 

	public void setName(String name) {
		this.name = name;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public Integer getDoctorId() {
		return doctorId;
	}

	public void setDoctorId(Integer doctorId) {
		this.doctorId = doctorId;
	}

	public Integer getPatientId() {
		return patientId;
	}

	public void setPatientId(Integer patientId) {
		this.patientId = patientId;
	}

	public LocalDate getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(LocalDate createdAt) {
		this.createdAt = createdAt;
	}

	public LocalDate getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(LocalDate updatedAt) {
		this.updatedAt = updatedAt;
	}

	 

 
	public UserResponseDto() {
		super();
	}

	public List<String> getAuthorities() {
		return authorities;
	}

	public void setAuthorities(List<String> authorities) {
		this.authorities = authorities;
	}

	public UserResponseDto(int userId, String name, String pass, String role, Integer doctorId, Integer patientId,
			LocalDate createdAt, LocalDate updatedAt, List<String> authorities) {
		super();
		this.userId = userId;
		this.name = name;
		this.pass = pass;
		this.role = role;
		this.doctorId = doctorId;
		this.patientId = patientId;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.authorities = authorities;
	}

	@Override
	public String toString() {
		return "UserResponseDto [userId=" + userId + ", name=" + name + ", pass=" + pass + ", role=" + role
				+ ", doctorId=" + doctorId + ", patientId=" + patientId + ", createdAt=" + createdAt + ", updatedAt="
				+ updatedAt + ", authorities=" + authorities + "]";
	}

	 

	 

	 
	
	
	
}
