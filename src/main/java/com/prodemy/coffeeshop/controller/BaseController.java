/**
 * 
 */
package com.prodemy.coffeeshop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * @author wyant
 *
 */
public class BaseController {
	@Autowired protected BCryptPasswordEncoder encoder;
	
	protected boolean hasRole(String role, Authentication auth) {
		for (GrantedAuthority a : auth.getAuthorities()) {
			if (a.getAuthority().equals(role)) return true;
		}
		return false;
	}
	
	protected String encrypt(String text) {
		return encoder.encode(text);
	}
}