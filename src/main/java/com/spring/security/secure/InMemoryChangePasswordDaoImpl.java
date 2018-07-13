package com.spring.security.secure;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

/**
 * Illustrates an extension to InMemoryDaoImpl which allows password changes.
 *
 * @author Mularien
 */
public class InMemoryChangePasswordDaoImpl extends InMemoryUserDetailsManager implements IChangePassword {
	/* (non-Javadoc)
	 * @see com.packtpub.springsecurity.security.IChangePassword#changePassword(java.lang.String, java.lang.String)
	 */
	@Override
	public void changePassword(String username, String password) {
		// get the UserDetails
		UserDetails userDetails = loadUserByUsername(username);
		// create a new UserDetails with the new password
		User newUserDetails = new User(userDetails.getUsername(),password,
				userDetails.isEnabled(),userDetails.isAccountNonExpired(),
				userDetails.isCredentialsNonExpired(),
				userDetails.isAccountNonLocked(),userDetails.getAuthorities());
		// add to the map
		createUser(newUserDetails);
	}
}
