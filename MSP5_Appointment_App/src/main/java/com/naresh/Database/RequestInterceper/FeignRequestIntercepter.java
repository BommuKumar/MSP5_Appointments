package com.naresh.Database.RequestInterceper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import jakarta.servlet.http.HttpServletRequest;

@Component
public class FeignRequestIntercepter implements RequestInterceptor{

	
	@Autowired
	HttpServletRequest request;
	
	@Override
	public void apply(RequestTemplate template) {

 	
		template.header("Authorization", request.getHeader("Authorization"));
		
	}

}
