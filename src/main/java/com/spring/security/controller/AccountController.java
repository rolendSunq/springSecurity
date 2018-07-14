package com.spring.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.provisioning.UserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Used to service account requests.
 *
 * @author Mularien
 */
@Controller
public class AccountController extends BaseController {

	@Autowired
	private UserDetailsManager userDetailsManager;

	@RequestMapping(value = "/account/home", method = RequestMethod.GET)
	public void accountHome() {
	}

	@RequestMapping(value = "/account/changePassword", method = RequestMethod.GET)
	public void showChangePasswordPage() {
	}


	/* Ch 4 UserDetailsManager version */
	@RequestMapping(value = "/account/changePassword", method = RequestMethod.POST)
	public String submitChangePasswordPage(@RequestParam("oldpassword") String oldPassword, @RequestParam("password") String newPassword) {
		userDetailsManager.changePassword(oldPassword, newPassword);
		SecurityContextHolder.clearContext();

		return "redirect:home";
	}
}
