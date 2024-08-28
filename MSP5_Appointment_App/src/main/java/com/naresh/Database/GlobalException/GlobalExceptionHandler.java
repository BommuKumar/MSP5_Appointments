package com.naresh.Database.GlobalException;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandlerImpl;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.naresh.Database.Dto.AppointmentResponseDto;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<String> AccessDeniedExceptionHandler(AccessDeniedException ex ) {
		 
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body(ex.getLocalizedMessage()+"your not Authorized to Access this Api");
	}
    

}
