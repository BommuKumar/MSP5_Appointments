package com.naresh.Database.Security;

import java.io.IOException;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import com.naresh.Database.Dto.UserResponseDto;
import com.naresh.Database.FeignClients.UserFeignClients;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.filter.OncePerRequestFilter;

import com.naresh.Database.JwtToken.JwtToken;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class JwtSecurityFilter extends OncePerRequestFilter {
	
	@Autowired
	 UserFeignClients userFeignClients;
	
	@Autowired
	JwtToken jwtToken;
	
	 

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		String token=request.getHeader("Authorization");
		
		 
		
		String tokenUserName=jwtToken.getUserNameOfToken(token);
		
		
		
		UserResponseDto existedUser=new UserResponseDto();
		 
		if(tokenUserName!=null)
		{
			 existedUser=userFeignClients.loadUserByUsername(tokenUserName).getBody();
		
		}
		
		System.out.println(existedUser);
		 
	if(tokenUserName!=null&& SecurityContextHolder.getContext().getAuthentication()==null)
	{
		
		boolean isValidToken=jwtToken.isValidToken(token, tokenUserName);
		
		
		if(isValidToken)
		{
			 Collection<? extends GrantedAuthority> roles=existedUser.getAuthorities().stream().map(role->new SimpleGrantedAuthority(role)).collect(Collectors.toList());
			
			UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken=
			new UsernamePasswordAuthenticationToken(existedUser, null, roles );
			
			SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
			
			 
		}
		else
		{
			System.out.println("invalid token ");	
	}
		
	 }
	
	System.out.println(SecurityContextHolder.getContext().getAuthentication());	
   
	filterChain.doFilter(request, response);	
		
		
	}

	
	 
}
