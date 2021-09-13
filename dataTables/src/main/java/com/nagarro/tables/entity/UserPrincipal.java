package com.nagarro.tables.entity;

import java.util.Collection;
import java.util.Collections;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class UserPrincipal implements UserDetails {

//
//	    private String email;
//
//	    private String password;

/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//	    private Collection<? extends GrantedAuthority> authorities;
	private User user;

	    

	    public UserPrincipal(User user) {
		this.user = user;
	}


//		public UserPrincipal create(User user) {
//
//	        return new UserPrincipal(
//	                user.getEmail(),
//	                user.getPassword(),
//	               new ArrayList<>()
//	        );
//	    }

	  
	    public String getEmail() {
	        return user.getEmail();
	    }

	 

	    @Override
	    public String getPassword() {
	        return user.getPassword();
	    }

	    @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        return Collections.emptyList();

	    }

	    @Override
	    public boolean isAccountNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isAccountNonLocked() {
	        return true;
	    }

	    @Override
	    public boolean isCredentialsNonExpired() {
	        return true;
	    }

	    @Override
	    public boolean isEnabled() {
	        return true;
	    }

	    @Override
	    public boolean equals(Object o) {
	       return true;
	    }

		@Override
		public String getUsername() {
			// TODO Auto-generated method stub
			return user.getEmail();
		}


		@Override
		public String toString() {
			return "UserPrincipal [user=" + user + "]";
		}

	    

 
}
