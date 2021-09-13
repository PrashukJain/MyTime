package com.nagarro.tables.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.nagarro.tables.entity.User;
import com.nagarro.tables.entity.UserPrincipal;
import com.nagarro.tables.repository.UserRepository;
@Service
public class CustomUserDetailService implements UserDetailsService {
	@Autowired
	private UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		// TODO Auto-generated method stub

		User user=userRepository.findById(email).get();

		if(user!=null) {
			
			return new UserPrincipal(user);
		}
		else {
			throw new UsernameNotFoundException("User not found !!"); 
		}
		
	}

}
