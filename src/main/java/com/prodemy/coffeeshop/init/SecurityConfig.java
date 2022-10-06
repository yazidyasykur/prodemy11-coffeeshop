/**
 * 
 */
package com.prodemy.coffeeshop.init;

import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.prodemy.coffeeshop.service.CustomUserDetailService;

/**
 * @author wyant
 *
 */
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	static UserDetailsService userDetailsService = null;
	static DaoAuthenticationProvider authenticationProvider = null;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	};

	@Bean
	public UserDetailsService userDetailsService() {
		if (userDetailsService==null) {
			userDetailsService = new CustomUserDetailService();
		}
		return userDetailsService;
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
				.formLogin()
				.loginPage("/login")
				.failureUrl("/?error=1")
				.defaultSuccessUrl("/owner")
				.loginProcessingUrl("/loginPage")
				.usernameParameter("userid")
				.passwordParameter("password")
				.and()
				.headers()
				.frameOptions().sameOrigin()
				.httpStrictTransportSecurity().disable()
				.and()
				.csrf().disable()
				.logout()
				.logoutUrl("/logout")
				.and()
				.authorizeRequests()
				.antMatchers(
						"/",
						"/daftar-menu",
						"/resources/**",
						"/accessdenied",
						"/assets/**").permitAll()
				.anyRequest().authenticated()
				.and()
					.exceptionHandling()
					.accessDeniedPage("/accessdenied");
	}
	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring().antMatchers("/login","/index","/customer","/resources/**");
	}
	
}
