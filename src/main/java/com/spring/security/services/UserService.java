package com.spring.security.services;

import org.springframework.security.access.prepost.PreAuthorize;

public interface UserService {
//	@PreAuthorize("hasRole('ROLE_ADMIN')")
	public void changePassword(String username, String password);
}
