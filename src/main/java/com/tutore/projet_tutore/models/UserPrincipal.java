package com.tutore.projet_tutore.models;

import com.tutore.projet_tutore.models.Entities.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class UserPrincipal implements UserDetails {

	private User user;


	public UserPrincipal(User user) {
		this.user = user;
	}

	
	 @Override
	    public Collection<? extends GrantedAuthority> getAuthorities() {
	        List<SimpleGrantedAuthority> authorities = new ArrayList<>();

	        return authorities;
	    }


	 

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getMotdepasse();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getEmail();
	}

	//return the id of current user
	public Integer getId() {
		
		return user.getId();
	}
	
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
