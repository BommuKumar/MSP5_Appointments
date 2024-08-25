package com.naresh.Database.FeignClients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.naresh.Database.Dto.UserResponseDto;

@FeignClient("MSP1-User-App")
public interface UserFeignClients {
	
	
	   @GetMapping(path="/User/get/{user}")
		public ResponseEntity<UserResponseDto>  loadUserByUsername(@PathVariable("user") String userName);
		 
}
