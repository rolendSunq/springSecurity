package com.spring.security.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * The base Spring MVC controller. Used to provide common functionality to all controllers.
 *
 * @author Mularien
 */
public class BaseController {
	protected Authentication getAuthentication() {
		// Authentication 구현 클래스를 리턴한다.
		return SecurityContextHolder.getContext().getAuthentication();
	}
	
	// showLoginLink model data value create
	@ModelAttribute("showLoginLink")
	public boolean getShowLoginLink() {
		for (GrantedAuthority authority : getAuthentication().getAuthorities()) {
			if (authority.getAuthority().equals("ROLE_USER")) {
				return false;
			}
		}
		
		return true;
	}
}
