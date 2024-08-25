package com.naresh.Database.JwtToken;

import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;

@Component
public class JwtToken {
	
	
	private static final String SCREATE_KRY="qwertyuiopasdfghjklasdfghjklzxcvbasdfghjklqwertyuiopzxcvb";

	
	
	public String getUserNameOfToken(String token)
	{
		String tokenUserName =  Jwts.parser()
				 .setSigningKey(SCREATE_KRY)
		 		  .parseClaimsJws(token)
				  .getBody()
				  .getSubject();
		
		
		return tokenUserName;
		
	}
	
	public boolean isTokenNotExpired(String token)
	{
		Date expiretime =  Jwts.parser()
				 .setSigningKey(SCREATE_KRY)
		 		  .parseClaimsJws(token)
				  .getBody()
				  .getExpiration();
		
		
		return 	expiretime.after(new Date());
		
	}
	
	
	   public boolean isValidUser(String token,String userName)
	    {
		
		return   getUserNameOfToken(token).equals(userName);
		   
	 	}
	
	   
	   public boolean isValidToken(String token,String userName)
	    {
		
		return   isValidUser(token,userName)&&isTokenNotExpired(token);
		   
	 	}
	
	
	

}
