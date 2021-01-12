package com.upfpo.app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	UserDetailsService userDetailsService;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(passwordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
//		 http
//         .authorizeRequests()
//         .anyRequest().authenticated()
//         .and()
//         .formLogin()
//         .loginPage("/UPFPO/login").permitAll();
		
		http.authorizeRequests().antMatchers("/user")
		.hasAnyRole("user")
		.antMatchers("/","/login").permitAll()
		.and().formLogin();
	}
	
//	@Bean
//	public PasswordEncoder getPasswordEncoder()
//	{
//		return NoOpPasswordEncoder.getInstance();
//	}
	
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
		
//		protected void configure1(HttpSecurity http) throws Exception { // "/.js", "/.jpg", "/.woff", "/*.ttf",
//			http.cors().disable().csrf().disable().authorizeRequests()
//					.antMatchers("/", "/assets///", "/token/login", "/signup", "/sendEmailLinkPassword",
//							"/changeForgotPassword","/userPasswordActiveStatus/*")
//					.permitAll().anyRequest().authenticated().and().exceptionHandling()
//					//.authenticationEntryPoint(unauthorizedHandler)
//
//					.and().sessionManagement().sessionFixation().changeSessionId().enableSessionUrlRewriting(false)
//					.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED).and().httpBasic().disable();
//			http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
//			http.addFilterBefore(corsFilter(), SessionManagementFilter.class);
//			http.addFilterBefore(activeIdFilter(), SessionManagementFilter.class);
//		}

}
