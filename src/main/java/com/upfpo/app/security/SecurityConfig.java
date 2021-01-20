package com.upfpo.app.security;

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
	UserDetailsService userDetailsService;
	
	@Autowired
	AuthTokenFilter authTokenFilter;
	

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
		
//		http.cors().disable().csrf().disable()
//		.authorizeRequests().antMatchers("/login")
//		.hasAnyRole("user")
//		.antMatchers("/").permitAll()
//		.and().formLogin();
		
		http.csrf().disable()
		.authorizeRequests()
		//.antMatchers("/UPFPO/**").permitAll()
		.antMatchers("/signin","/home/farmer","/home/production","/home/search",
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

	http.addFilterBefore(authTokenFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception{
		return super.authenticationManagerBean();
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
//					.antMatchers("/", "/assets///", "/login", "/signup", "/sendEmailLinkPassword",
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
