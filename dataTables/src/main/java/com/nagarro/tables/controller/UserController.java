package com.nagarro.tables.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nagarro.tables.entity.JwtResponse;
import com.nagarro.tables.entity.User;
import com.nagarro.tables.exception.CustomException;
import com.nagarro.tables.helper.JwtUtil;
import com.nagarro.tables.service.CustomUserDetailService;
@RestController
@CrossOrigin
@RequestMapping("/api")
public class UserController {
	@Autowired
	private AuthenticationManager authenticationManager;
	@Autowired
	private CustomUserDetailService customUserDetailService;
	@Autowired
	private JwtUtil jwtUtil;
	@PostMapping("/login")
	public ResponseEntity<?> generateToken(@RequestBody User jwtRequestUser) throws Exception{
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(jwtRequestUser.getEmail(), jwtRequestUser.getPassword()));
		}
		catch(Exception e) {
			throw new CustomException("Bad Credentials");
		}
		UserDetails userDetails=this.customUserDetailService.loadUserByUsername(jwtRequestUser.getEmail());
	String token=this.jwtUtil.generateToken(userDetails);
	return ResponseEntity.ok(new JwtResponse(token));
	}
//	public boolean login(@RequestBody User user) {
//		System.out.println("login");
//		return userService.loginService(user);
//	}

}
