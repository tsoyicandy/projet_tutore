package com.tutore.projet_tutore.service;


import com.tutore.projet_tutore.models.Entities.User;
import com.tutore.projet_tutore.models.UserPrincipal;
import com.tutore.projet_tutore.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class MyUserDetailsService implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User user = userRepository.findByEmail(username);

		if(user==null) {
			throw new UsernameNotFoundException("Utilisateur introuvable!");
		}
		System.out.println(user.toString());
		return new UserPrincipal(user);

	}




}
