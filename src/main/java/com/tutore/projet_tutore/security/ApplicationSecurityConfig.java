package com.tutore.projet_tutore.security;

import com.tutore.projet_tutore.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


@EnableWebSecurity
@Configuration
public class ApplicationSecurityConfig extends WebSecurityConfigurerAdapter {



	@Override
	protected void configure(HttpSecurity http) throws Exception {



		http
		.csrf().disable()

		.authorizeRequests()
		.antMatchers(
				"/enregistreruser",
				"/resources/**",
				"/css/**",
				"/fonts/**", "/images/**","/js/**",
				"/scss/**","/vendor/**").permitAll()
		.antMatchers("/inscription","/connexion","/","/creer").permitAll()

		.anyRequest().authenticated()
		.and()
		.formLogin()
		.loginPage("/connexion").permitAll()
		.and()
		.logout().invalidateHttpSession(true)
		.clearAuthentication(true)
		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
		.logoutSuccessUrl("/").permitAll();

	}

	  
  @Bean
  public BCryptPasswordEncoder bCryptPasswordEncoder() {
	  
	  return new BCryptPasswordEncoder();
	   
	  }
 

	@Autowired
	private UserDetailsService userDetailsService;
	

	@Bean
	public AuthenticationProvider authentication() {
		
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		
		provider.setUserDetailsService(userDetailsService);
		
		provider.setPasswordEncoder(bCryptPasswordEncoder());
		
		return provider;
	}

	 @Bean
	    public UserDetailsService userDetailsService() {
	        return new MyUserDetailsService();
	    }

	    @Bean
	    public DaoAuthenticationProvider authenticationProvider() {
	        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
	        authProvider.setUserDetailsService(userDetailsService());
	        authProvider.setPasswordEncoder(bCryptPasswordEncoder());
	         
	        return authProvider;
	    }

	    @Override
	    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	        auth.authenticationProvider(authenticationProvider());
	    }
	
}
