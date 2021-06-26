package com.springBoot.BloodBank;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.configurers.AbstractInterceptUrlConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@EnableWebSecurity
public class ProjectConfig extends WebSecurityConfigurerAdapter{

	@Autowired
	UserDetailsService userDetailService;
	@Autowired
	JwtAuthenticatonFilter jwtAuthenticationFilter;
	
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService);
	}
	
//	@Bean
//	public WebMvcConfigurer corsConfigurer() {
//		return new WebMvcConfigurer() {
//			@Override
//			public void addCorsMappings(CorsRegistry registry) {
//				registry.addMapping("/**")
//				.allowedMethods("GET", "POST", "PUT", "DELETE")
//				.allowedHeaders("*")
//				.allowedOrigins("http://localhost:4200");
//			}
//		};
//	}	
	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		
		http
			.cors().and()
			.authorizeRequests()
				.antMatchers("/scroll").hasAnyRole("ADMIN","USER")
				.antMatchers("/getData").hasAnyRole("ADMIN","USER")
				.antMatchers("/request").hasAnyRole("ADMIN","USER")
			 	.antMatchers("/save").permitAll()
			 	.antMatchers("/check").permitAll()
			 	.antMatchers("/find").hasAnyRole("ADMIN","USER")
			 	.antMatchers("/count").hasAnyRole("ADMIN","USER")
			 	.antMatchers("/aUser").hasRole("ADMIN")
			 	.antMatchers("/deleted").hasRole("ADMIN")
			 	.anyRequest().authenticated()
			 	.and()
				.logout().invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/").permitAll()
			 	.and().sessionManagement()
			 	.sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		http.csrf().disable();
		http.addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
	}
	
	@Override
	@Bean
	public AuthenticationManager authenticationManagerBean() throws Exception {
		// TODO Auto-generated method stub
		return super.authenticationManagerBean();
	}

	
}

