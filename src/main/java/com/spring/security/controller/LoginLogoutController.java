package com.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * This controller is used to provide functionality for the login page.
 *
 * @author Mularien
 */
@Controller
public class LoginLogoutController extends BaseController{

	@RequestMapping(value = {"/", "/login"}, method = RequestMethod.GET)
	public String moveLoginPageCTRL() {

		return "login";
	}

	@RequestMapping(value = "/logoutSuccessful")
	public String logoutSuccessfulCTRL() {
		return "login";
	}
}
