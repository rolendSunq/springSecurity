/**
 * 
 */
package com.spring.security.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.security.security.ChangePassword;


/**
 * Implements methods declared in the UserService interface.
 * 
 * @author Mularien
 */
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private ChangePassword changePasswordDao;
	
	@Override
	public void changePassword(String username, String password) {
		changePasswordDao.changePassword(username, password);
	}
}
