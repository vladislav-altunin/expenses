package com.vlad.expenses;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.vlad.expenses.Service.UserDetailServiceImpl;


@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	// Inject authentication and authorization
		@Autowired
		private UserDetailServiceImpl userDetailsServiceImpl;

		// Enable h2-console (otherwise error 403)
		
		public void configure(WebSecurity web) throws Exception {
			web.ignoring().antMatchers("/h2-console/**", "/resources/**", "/static/**","/webjars/**");
		}

		// Secure URLs (all URLs are secured by default)
		// Define login page
		
		protected void configure(HttpSecurity http) throws Exception {
			http.authorizeRequests().antMatchers("/login", "/css/**",
	                "/js/**",
	                "/img/**",
	                "/**/favicon.ico",
	                "/webjars/**",
	                "/signup").permitAll()
					.antMatchers("/delete/**").hasAuthority("ADMIN")
					.anyRequest().authenticated()
					.and()
				.formLogin().loginPage("/login")
					.defaultSuccessUrl("/index", true)
					.permitAll();
		}

	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsServiceImpl).passwordEncoder(new BCryptPasswordEncoder());
	}

}
