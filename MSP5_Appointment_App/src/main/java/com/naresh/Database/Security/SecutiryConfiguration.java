package com.naresh.Database.Security;

import org.modelmapper.ModelMapper;

import org.modelmapper.PropertyMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
public class SecutiryConfiguration {
	
	 
   @Bean
	public JwtSecurityFilter JwtSecurityFilter()
	{
		return new JwtSecurityFilter();
	}
	
	   @Bean
		SecurityFilterChain httpSecurity(HttpSecurity security)
		{
			
			
			SecurityFilterChain filterChain=null;
			  
				
				
				try {
					security.csrf(csrf->csrf.disable())
					       .cors(cors->cors.disable())
					       .authorizeHttpRequests(
					    		    authorize->authorize //.requestMatchers("/patient/**")
					    		   //.permitAll()
					    		    .anyRequest()
					    		     .authenticated()
					       )
					   
					   .addFilterBefore(JwtSecurityFilter(), UsernamePasswordAuthenticationFilter.class);
				} catch (Exception e) {

					e.printStackTrace();
				}
				
				
				try {
					filterChain=security.build();
				} catch (Exception e) {
					e.printStackTrace();
				}
				
		 		
			return filterChain;
			
		}

}
