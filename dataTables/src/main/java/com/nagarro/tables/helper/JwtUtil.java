package com.nagarro.tables.helper;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.internal.Function;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.nagarro.tables.repository.AirportInfoRepository;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

//methods for generating token
//validate
//isExp
//util class for jwt
@Component
public class JwtUtil {
	@Autowired
	AirportInfoRepository airportinfoRepository;
	 private String SECRET_KEY = "datatable3163370";

	    public String getUsername(String token) {
	        return getClaim(token, Claims::getSubject);
	    }

	    public Date getExpiration(String token) {
	        return getClaim(token, Claims::getExpiration);
	    }

	    public <T> T getClaim(String token, Function<Claims, T> claimsResolver) {
	        final Claims claims = getAllClaims(token);
	        return claimsResolver.apply(claims);
	    }
	    private Claims getAllClaims(String token) {
	        return Jwts.parser().setSigningKey(SECRET_KEY).parseClaimsJws(token).getBody();
	    }

	    private Boolean isTokenExpired(String token) {
	        return getExpiration(token).before(new Date());
	    }

	    public String generateToken(UserDetails userDetails) {
	        Map<String, Object> claims = new HashMap<>();
	        claims.put("city",airportinfoRepository.allCities());
	        claims.put("country",airportinfoRepository.allCountries());
	        return createToken(claims, userDetails.getUsername());
	    }

	    private String createToken(Map<String, Object> claims, String subject) {

	        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis()))
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 10))
	                .signWith(SignatureAlgorithm.HS256, SECRET_KEY).compact();
	    }

	    public Boolean validateToken(String token, UserDetails userDetails) {
	        final String username = getUsername(token);
	        return (username.equals(userDetails.getUsername()) && !isTokenExpired(token));
	    }
}
