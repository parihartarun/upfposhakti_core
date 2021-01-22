package com.upfpo.app.security;

import com.upfpo.app.security.jwt.JwtTokenFilterConfigurer;
import com.upfpo.app.security.jwt.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.upfpo.app.security.jwt.AuthTokenFilter;


@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{

	
	@Autowired
	AuthTokenFilter authTokenFilter;

	@Autowired
	JwtUtils jwtTokenProvider;

	@Override
	protected void configure(HttpSecurity http) throws Exception {	
		http
		.csrf().disable()
		.authorizeRequests()
		//.antMatchers("/UPFPO/**").permitAll()
		.antMatchers("/signin","/home/farmer","/home/production","/home/search","/signin/home","/register/**","/api/v1/**",
				"/v3/api-docs",
				"/v2/api-docs",
                "/configuration/ui",
                "/swagger-resources/**",
                "/configuration/security",
                "/swagger-ui.html",
                "/swagger-ui/**",
                "/api/v1/**",
                "/webjars/**"
				).permitAll()
		.anyRequest().authenticated()
		.and().sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	http.cors();
	http.apply(new JwtTokenFilterConfigurer(jwtTokenProvider));
	http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
	}

	@Bean
	public PasswordEncoder passwordEncoder(){
		PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String password = "pass";
		String encodedPassword = passwordEncoder.encode(password);
		System.out.println();
		System.out.println("Password is         : " + password);
		System.out.println("Encoded Password is : " + encodedPassword);
		System.out.println();

		boolean isPasswordMatch = passwordEncoder.matches(password, encodedPassword);
		System.out.println("Password : " + password + "   isPasswordMatch    : " + isPasswordMatch);
		return passwordEncoder;
	}
		


}
